package com.example.administrator.videopiledemo.videoActivity.maintain.equipmentManagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.videopiledemo.R;

public class EquipmentManagementActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_coil,bt_backEquipment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_management);
        init();
    }
    public void init(){
        bt_coil=(Button) findViewById(R.id.bt_coil);
        bt_backEquipment=(Button) findViewById(R.id.bt_backEquipment);
        bt_coil.setOnClickListener(this);
        bt_backEquipment.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_backEquipment://返回上层
                finish();
                break;
           case  R.id.bt_coil://虚拟线圈
            startActivity(new Intent().setClass(EquipmentManagementActivity.this,SetPictureActivity.class));
            break;
        }
    }
}
