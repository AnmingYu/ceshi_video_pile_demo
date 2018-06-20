package com.example.administrator.videopiledemo.videoActivity.maintain.equipmentManagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.videopiledemo.R;

public class SetPictureActivity extends AppCompatActivity implements View.OnClickListener{
    private String TAG="SetPictureActivity";
    private String url = "http://img.my.csdn.net/uploads/201309/01/1378037128_5291.jpg";
    private Button bt_leftSetPicture,bt_rightSetPicture,bt_confirmSetPicture,bt_amendSetPicture,bt_backSetPicture;
    private ImageView iv_pictureSetPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_picture);
        initData();
    }
    public void initData(){
        bt_leftSetPicture=(Button) findViewById(R.id.bt_leftSetPicture);
        bt_rightSetPicture=(Button) findViewById(R.id.bt_rightSetPicture);
        bt_confirmSetPicture=(Button) findViewById(R.id.bt_confirmSetPicture);
        bt_amendSetPicture=(Button) findViewById(R.id.bt_amendSetPicture);
        bt_backSetPicture=(Button) findViewById(R.id.bt_backSetPicture);
        iv_pictureSetPicture=(ImageView) findViewById(R.id.iv_pictureSetPicture);

        bt_leftSetPicture.setOnClickListener(this);
        bt_rightSetPicture.setOnClickListener(this);
        bt_confirmSetPicture.setOnClickListener(this);
        bt_amendSetPicture.setOnClickListener(this);
        bt_backSetPicture.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_backSetPicture://返回上层
                finish();
                break;
            case R.id.bt_leftSetPicture://左侧摄像头
                Glide.with(SetPictureActivity.this).load(url).into(iv_pictureSetPicture);
                break;
            case R.id.bt_rightSetPicture://右侧摄像头
                Glide.with(SetPictureActivity.this).load(url).into(iv_pictureSetPicture);
                break;
            case R.id.bt_confirmSetPicture://确定

                break;
            case R.id.bt_amendSetPicture://修改

                break;
        }
    }

}
