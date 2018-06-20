package com.example.administrator.videopiledemo.videoActivity.pay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.videopiledemo.R;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG="PayActivity";
    private Button bt_left,bt_right,bt_determine,bt_cancel,bt_back;
    private RelativeLayout rl_back;
    public static final String OBTAIN_PLATE_NUMBER = "OBTAIN_PLATE_NUMBER";

    private EditText et_licensePlateNumber;
    private String edit="";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initData();
    }
public void initData(){
    bt_left=(Button) findViewById(R.id.bt_left);
    bt_right=(Button) findViewById(R.id.bt_right);
    bt_determine=(Button) findViewById(R.id.bt_determine);
    bt_cancel=(Button) findViewById(R.id.bt_cancel);
    bt_back=(Button) findViewById(R.id.bt_back);

    rl_back=(RelativeLayout) findViewById(R.id.rl_back);
    et_licensePlateNumber=(EditText) findViewById(R.id.et_licensePlateNumber);

    bt_left.setOnClickListener(this);
    bt_right.setOnClickListener(this);
    bt_determine.setOnClickListener(this);
    bt_cancel.setOnClickListener(this);
    bt_back.setOnClickListener(this);

    rl_back.setOnClickListener(this);
    //et_licensePlateNumber.setOnClickListener(this);
}
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.bt_left://左侧
                intextOver();
                break;
            case R.id.bt_right://右侧
                intextOver();
                break;
            case R.id.bt_determine://确定
                obtainEditText();
                et_licensePlateNumber.setText("");
                break;
            case R.id.bt_cancel://取消
                finish();
                break;
        }
    }
    //跳转到FeesActivityt页面
    public void intextOver(){
        startActivity(new Intent().setClass(PayActivity.this, FeesActivity.class));
    }
    public void obtainEditText(){
        Intent intent=new Intent(PayActivity.this, FeesActivity.class);
        edit=et_licensePlateNumber.getText().toString();
        intent.putExtra(OBTAIN_PLATE_NUMBER,edit);
        if (edit==""||edit==""){
            Toast.makeText(context,"请输入有效车牌号",Toast.LENGTH_SHORT);
        }else {
            this.startActivity(intent);
            Log.e(TAG, "obtainEditText: "+edit);
        }
    }
}
