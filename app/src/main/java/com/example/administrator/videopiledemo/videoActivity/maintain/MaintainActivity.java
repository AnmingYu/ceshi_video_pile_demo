package com.example.administrator.videopiledemo.videoActivity.maintain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.administrator.videopiledemo.R;
import com.example.administrator.videopiledemo.videoActivity.maintain.equipmentManagement.EquipmentManagementActivity;
import com.example.administrator.videopiledemo.videoActivity.maintain.equipmentManagement.SetPictureActivity;
import com.example.administrator.videopiledemo.videoActivity.maintain.incidentManagement.IncidentManagementActivity;
import com.example.administrator.videopiledemo.videoActivity.maintain.mainBrowsingInterface.MainBrowsingInterfaceActivity;

public class MaintainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bt_backmaintain,bt_mainBrowsingInterface,bt_logSearch,bt_systemConfiguration,bt_userControl,bt_equipmentManagement
            ,bt_storagePlan,bt_incidentManagement;
    private RelativeLayout rl_backmaintain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);
        initData();
    }
    public void initData(){
        bt_backmaintain=(Button) findViewById(R.id.bt_backmaintain);
        bt_mainBrowsingInterface=(Button) findViewById(R.id.bt_mainBrowsingInterface);
        bt_logSearch=(Button) findViewById(R.id.bt_logSearch);
        bt_systemConfiguration=(Button) findViewById(R.id.bt_systemConfiguration);
        bt_userControl=(Button) findViewById(R.id.bt_userControl);
        bt_equipmentManagement=(Button) findViewById(R.id.bt_equipmentManagement);
        bt_storagePlan=(Button) findViewById(R.id.bt_storagePlan);
        bt_incidentManagement=(Button) findViewById(R.id.bt_incidentManagement);
        rl_backmaintain=(RelativeLayout) findViewById(R.id.rl_backmaintain);

        bt_backmaintain.setOnClickListener(this);
        bt_mainBrowsingInterface.setOnClickListener(this);
        bt_logSearch.setOnClickListener(this);
        bt_systemConfiguration.setOnClickListener(this);
        bt_userControl.setOnClickListener(this);
        bt_equipmentManagement.setOnClickListener(this);
        bt_storagePlan.setOnClickListener(this);
        bt_incidentManagement.setOnClickListener(this);
        rl_backmaintain.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_backmaintain://返回上层
                finish();
                break;
            case R.id.bt_mainBrowsingInterface://主浏览界面
                startActivity(new Intent().setClass(MaintainActivity.this, MainBrowsingInterfaceActivity.class));
                break;
            case R.id.bt_logSearch://日志搜索
                break;
            case R.id.bt_systemConfiguration://系统配置
                break;
            case R.id.bt_userControl://用户管理
                break;
            case R.id.bt_equipmentManagement://设备管理
                startActivity(new Intent().setClass(MaintainActivity.this,EquipmentManagementActivity.class));
                break;
            case R.id.bt_storagePlan://存储计划
                break;
            case R.id.bt_incidentManagement://事件管理
                startActivity(new Intent().setClass(MaintainActivity.this, IncidentManagementActivity.class));
                break;
        }
    }
}
