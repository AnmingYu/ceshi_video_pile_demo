package com.example.administrator.videopiledemo.videoActivity.pay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.videopiledemo.R;

public class FeesActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt_backtrack;
    private RelativeLayout rl_backtrack;
    /**
     * tv_beginTime 开始时间
     *tv_finishTime 结束时间
     * tv_timeBucket 停车时长
     * tv_cost 费用
     * tv_plate 车牌号
     * */
    private TextView tv_beginTime,tv_finishTime,tv_timeBucket,tv_cost,tv_plate;
    private String info="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);
        initData();
        Intent intent=this.getIntent();
        info= intent.getStringExtra(PayActivity.OBTAIN_PLATE_NUMBER);
       // tv_plate.setText(info);
    }
    public void initData(){
        bt_backtrack=(Button) findViewById(R.id.bt_backtrack);
        rl_backtrack=(RelativeLayout) findViewById(R.id.rl_backtrack);

        rl_backtrack.setOnClickListener(this);
        bt_backtrack.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_backtrack:
                finish();
                break;
        }
    }

}
