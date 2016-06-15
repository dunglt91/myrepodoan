package hrm.pack.dunglt.client_hrm;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {


    private EditText userName;
    private EditText passWords;
    private Button button;
    private TextView tv;
    private Handler handler = new Handler();
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        passWords = (EditText) findViewById(R.id.passWord);
        button = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dialog = new ProgressDialog(this);
        dialog.setMessage("process...");
        dialog.setTitle("test login");
        dialog.show();
        Thread t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        String uname = userName.getText().toString();
        String pass = passWords.getText().toString();
        try {
            wsDangNhap dangNhap = new wsDangNhap();
            final String result = dangNhap.TestLogin(uname,pass);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    tv.setText("debug: " + result);
                }
            });

        } catch (Exception e) {
            Log.e("mainac","err",e);
        } finally {
            dialog.dismiss();
        }
    }
}