package com.example.administrator.videopiledemo;

import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.administrator.videopiledemo.videoActivity.maintain.MaintainActivity;
import com.example.administrator.videopiledemo.videoActivity.pay.PayActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_pay,bt_maintain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRealSize();
        Data();

    }
    //数据初始化
    public void Data(){
       bt_pay=(Button) findViewById(R.id.bt_pay);
       bt_maintain=(Button) findViewById(R.id.bt_maintain);
       bt_pay.setOnClickListener(this);
        bt_maintain.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_pay:
                startActivity(new Intent().setClass(MainActivity.this, PayActivity.class));
                break;
            case R.id.bt_maintain:
                startActivity(new Intent().setClass(MainActivity.this, MaintainActivity.class));
                break;
        }
    }

    private void getRealSize() {
        WindowManager w = this.getWindowManager();
        Display d = w.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        d.getMetrics(metrics);
// since SDK_INT = 1;
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
// includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17)
            try {
                widthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(d);
                heightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(d);
            } catch (Exception ignored) {
            }
// includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 17)
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(d, realSize);
                widthPixels = realSize.x;
                heightPixels = realSize.y;
            } catch (Exception ignored) {
            }
        double size=(Math.sqrt(Math.pow(widthPixels, 2) + Math.pow(heightPixels, 2))) / metrics.densityDpi;
        Log.e("TAG", "widthPixels"+widthPixels);
        Log.e("TAG", "heightPixels"+heightPixels);
        Log.e("TAG", "size"+size);
        // 通过WindowManager获取
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Log.e("TAG","width-display :" + dm.widthPixels);
        Log.e("TAG","width-display :" + dm.heightPixels);
// 通过Resources获取
        DisplayMetrics dm2 = getResources().getDisplayMetrics();

        Log.e("TAG","width-display :" + dm2.widthPixels);
        Log.e("TAG","width-display :" + dm2.heightPixels);

// 获取屏幕的默认分辨率
        Display display = getWindowManager().getDefaultDisplay();

        Log.e("TAG","width-display :" +  display.getWidth());
        Log.e("TAG","width-display :" + display.getHeight());

    }
}
