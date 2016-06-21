package hrm.pack.dunglt.client_hrm;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import hrm.client.util.ClientUtil;
import hrm.client.util.StringPool;
import ws.model.Tlu30lichPhongVan;

public class kqpv extends AppCompatActivity implements View.OnClickListener, Runnable  {
    private Handler handler = new Handler();
    private ProgressDialog dialog;
    private Button button;
    private ListView listView;
    private String [] kqpv;
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

        try {
            wsKetQuaPhongVan ketQuaPhongVan = new wsKetQuaPhongVan();
            tlu30lichPhongVen = ketQuaPhongVan.displayAllData();

            if(!tlu30lichPhongVen.isEmpty()) {
                for(int i = 0; i < tlu30lichPhongVen.size(); i++) {
                    kqpv = new String[tlu30lichPhongVen.size()];
                    String stringBuffer = StringPool.BLANK;
                    String khs = tlu30lichPhongVen.get(i).getKeHoachSo();
                    String ungVien = tlu30lichPhongVen.get(i).getUngVien();
                    String datYeuCau = ClientUtil.isPass(tlu30lichPhongVen.get(i).isDatYeuCau());
                    stringBuffer = (khs + "\n") + (ungVien + "\n") + (datYeuCau + "\n");


                    kqpv[i] = stringBuffer;
                    adapter.add(kqpv[i]);
                }
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if(!adapter.isEmpty()) {
                        listView.setAdapter(adapter);
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
