package com.example.administrator.videopiledemo.videoActivity.maintain.incidentManagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.videopiledemo.R;

public class IncidentManagementActivity extends AppCompatActivity implements View.OnClickListener {
    /*
    * rl_warningQuery 历史警告
    * rl_eventQuery 历史事件
    *rl_backmaintain 返回框
    * */
    private RelativeLayout rl_warningQuery,rl_eventQuery ,rl_backmaintain;
    private Button bt_eventQuery,bt_warningQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_management);
        init();
    }
    public void init(){

        bt_eventQuery=(Button) findViewById(R.id.bt_eventQuery);
        bt_warningQuery=(Button) findViewById(R.id.bt_warningQuery);

        rl_warningQuery=(RelativeLayout)findViewById(R.id.rl_warningQuery);
        rl_eventQuery=(RelativeLayout)findViewById(R.id.rl_eventQuery);
        rl_backmaintain=(RelativeLayout)findViewById(R.id.rl_backmaintain);

        bt_eventQuery.setOnClickListener(this);
        bt_warningQuery.setOnClickListener(this);

        rl_warningQuery.setOnClickListener(this);
        rl_eventQuery.setOnClickListener(this);
        rl_backmaintain.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_backmaintain://返回事件
                finish();
                break;
            case R.id.rl_warningQuery://历史警告查询
            case R.id.bt_warningQuery:

                break;
            case R.id.rl_eventQuery://历史事件查询
            case R.id.bt_eventQuery:
                startActivity(new Intent().setClass(IncidentManagementActivity.this,HistoryIncidentActivity.class));
                break;
        }
    }
}
