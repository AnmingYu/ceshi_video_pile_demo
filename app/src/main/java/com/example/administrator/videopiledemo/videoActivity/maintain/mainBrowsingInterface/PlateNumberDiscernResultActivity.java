package com.example.administrator.videopiledemo.videoActivity.maintain.mainBrowsingInterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.videopiledemo.R;

public class PlateNumberDiscernResultActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_confirm,bt_abnormity,bt_backMainBrowsing;
    private TextView tv_plateNumblesText;
    private ImageView iv_plateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plate_number_discern_result);
        initData();
        plateNumblesText();
    }
    public void initData(){
        bt_confirm=(Button) findViewById(R.id.bt_confirm);
        bt_abnormity=(Button) findViewById(R.id.bt_abnormity);
        bt_backMainBrowsing=(Button) findViewById(R.id.bt_backMainBrowsing);
        iv_plateImage=(ImageView) findViewById(R.id.iv_plateImage);
        tv_plateNumblesText=(TextView) findViewById(R.id.tv_plateNumblesText);

        bt_confirm.setOnClickListener(this);
        bt_abnormity.setOnClickListener(this);
        bt_backMainBrowsing.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_confirm://确定
                finish();
                break;
            case R.id.bt_abnormity://异常
                break;
            case R.id.bt_backMainBrowsing://返回
                finish();
                break;
        }
    }
    //获取车牌信息
    public void plateNumblesText(){
        tv_plateNumblesText.setText("沪F.88888");
    }
}
