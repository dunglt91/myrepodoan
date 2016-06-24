package hrm.pack.dunglt.client_hrm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import hrm.client.util.ClientUtil;
import hrm.client.util.StringPool;
import ws.model.Tlu30chitietketquavpv;
import ws.model.Tlu30lichPhongVan;

public class kqpv extends AppCompatActivity implements View.OnClickListener, Runnable  {
    private Handler handler = new Handler();
    private ProgressDialog dialog;
    private Button button;
    private ListView listView;
    private String [] kqpv;
    public List<Tlu30chitietketquavpv> tlu30chitietketquavpvs;
    private ArrayAdapter<String> adapter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kqpv);
        button = (Button) findViewById(R.id.button2);
        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView4);
        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dialog = new ProgressDialog(this);
        dialog.setMessage("process...");
        dialog.setTitle("tim kiem ket qua phong van");
        dialog.show();
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        final List<Tlu30lichPhongVan> tlu30lichPhongVen;
        final wsKetQuaPhongVan ketQuaPhongVan;
        final wsChiTietKqpv wsChiTietKqpv;
        try {
            wsChiTietKqpv = new wsChiTietKqpv();
            ketQuaPhongVan = new wsKetQuaPhongVan();
            tlu30lichPhongVen = ketQuaPhongVan.displayAllData();

            tlu30chitietketquavpvs = wsChiTietKqpv.getAll();
            if(!tlu30lichPhongVen.isEmpty()) {
                for(int i = 0; i < tlu30lichPhongVen.size(); i++) {
                    kqpv = new String[tlu30lichPhongVen.size()];
                    String stringBuffer = StringPool.BLANK;
                    String khs = tlu30lichPhongVen.get(i).getKeHoachSo();
                    String ungVien = tlu30lichPhongVen.get(i).getUngVien();
                    String datYeuCau = ClientUtil.isPass(tlu30lichPhongVen.get(i).isDatYeuCau());
                    stringBuffer = ("Kế hoạch số: " + khs + "\n") + ("Mã ứng viên: " + ungVien + "\n") + ("Kết quả: " + datYeuCau + "\n");
                    kqpv[i] = stringBuffer;
                    adapter.add(kqpv[i]);
                }
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(!adapter.isEmpty()) {
                        listView.setAdapter(adapter);
                        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String maHs = StringPool.BLANK;
                                maHs = tlu30lichPhongVen.get(position).getUngVien();
                                StringBuffer stringBuffer = new StringBuffer();
                                if(!maHs.equals(StringPool.BLANK)) {
                                    try {
                                        tlu30chitietketquavpvs = wsChiTietKqpv.findCommon(maHs, null, null, null, null);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (XmlPullParserException e) {
                                        e.printStackTrace();
                                    }
                                    if(!tlu30chitietketquavpvs.isEmpty()) {
                                        for(Tlu30chitietketquavpv chitietketquavpv : tlu30chitietketquavpvs ) {
                                            String maUngVien = chitietketquavpv.getMachitietdmkqpv();
                                            String tenDktd = chitietketquavpv.getTendkpv();
                                            String diemDatDuoc = String.valueOf(chitietketquavpv.getDiemdatduoc());

                                            stringBuffer.append("Mã ứng viên: " + maUngVien + "\n");
                                            stringBuffer.append("Tên điều kiện tuyển dụng: " + tenDktd + "\n");
                                            stringBuffer.append("Điểm đạt được: " + diemDatDuoc + "\n");

                                        }
                                    }
                                }


                                Toast.makeText(kqpv.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();;
                            }
                        });*/
                    } else {
                        textView.setText("Không có kết quả hiển thị");
                    }
                }
            });

        } catch (Exception e) {
            Log.e("err","kqpv", e);
            e.printStackTrace();
        } finally {
            dialog.dismiss();
        }

    }
}
