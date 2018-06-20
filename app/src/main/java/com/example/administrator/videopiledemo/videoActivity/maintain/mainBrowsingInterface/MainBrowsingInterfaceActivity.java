package com.example.administrator.videopiledemo.videoActivity.maintain.mainBrowsingInterface;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.administrator.videopiledemo.R;
import com.example.administrator.videopiledemo.adapterGather.FormsAdapter;
import com.example.administrator.videopiledemo.entity.FormsParameter;
import com.example.administrator.videopiledemo.functionEncapsulation.OnDoubleClickListener;
import com.example.administrator.videopiledemo.functionEncapsulation.TimeTaskScroll;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class MainBrowsingInterfaceActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG="MainBrowsingInterfaceActivity";
    private VideoView vv_cameraone,vv_cameratwo;
    private Context mContext;
    private List<FormsParameter> mData = null;
    private static final int INT_STATE_SHUJU=10;
    /*
    * INCIDENT  0 为告警 1 为事件
    * */
    private int INCIDENT=0;
    private FormsAdapter mFormsAdapter;

    private Button bt_backMainBrowsing,bt_facilityone,bt_facilitytwo,bt_playButtonmain,bt_fullScreen,bt_uniformScreen,bt_ProcAmp,
                    bt_RVC,bt_historicalStorage,bt_superposition,bt_start,bt_fauna,bt_plateNumber,bt_exercise,bt_upward,bt_wicket,
                    bt_nail,bt_upwardtwo,bt_wickettwo,bt_nailtwo,bt_backMainBrowsingform,bt_alarm,bt_incidenttwo,bt_incident,bt_backMainBrowsingformtwo,
                    bt_alarmtwo;
    /*
    * rl_topbrowsing顶部标题框 rl_SuperpositionOfImages视频窗口的显示信息 rl_topbrowsingform 全局form放大后的标题框
    * ll_btnPage 操作视频 ll_downwardOperatingBox向上的布局 ll_videodisplayFrame 视频显示框 ll_middleLayout 中间的布局
    *lv_forms   listView 获取数据 表单 告警 LL_formtwo 表单 事件 ll_superposition  叠加 rl_ControlPicture  控制视频按钮的布局
    *  ll_shipin_browsing  控制视频按钮的布局
    * */
    private RelativeLayout rl_closeForm,rl_openForm,rl_topbrowsing,rl_SuperpositionOfImages,rl_topbrowsingform,rl_topbrowsingformtwo,
            rl_ControlPicture,rl_seeks;
    private LinearLayout ll_btnPage,LL_form,ll_downwardOperatingBox,ll_videodisplayFrame,ll_middleLayout,LL_formtwo,ll_superposition,ll_shipin_browsing;
    private ListView  lv_forms,lv_formsIncident;
    /*
    * tv_division 分割线，为了显示出双视频展示时保持区分 tv_divisionRight边距问题 tv_start 开启 关闭 tv_exercise 运动  tv_plateNumber 车牌
    *  tv_fauna 物体 tv_superposition 叠加
    * */
    private TextView tv_division,tv_divisionRight,tv_start,tv_exercise,tv_plateNumber,tv_fauna,tv_superposition,tv_left;
    private int shallowBlue;
    private int lightGray;
    private int yellow;

    /*
    * swith  总开关的状态 exercise  运动的状态 plate 车牌的状态 fauna 物类的状态 start 启动状态 splitScreen 显示屏分区 fullScreen 是否全屏
    *  startStatus 启动状态 DisplayStatus 显示屏的显示状态 cameraState 摄像头状态 cameraStateTwo第二个摄像头状态 upward 显示表单
    * */
    private Boolean swith=false,exercise=false,plate=false,fauna=false,start=false,splitScreen=false,
                     fullScreen=false,startStatus=false,DisplayStatus=false,viewingScreen=false,cameraState=false,
                     cameraStateTwo=false,upward=false,superposition=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_browsing_interface);
        init();
        cameraShooting();
        formListView();
    }
    public void init(){
        bt_backMainBrowsing=(Button) findViewById(R.id.bt_backMainBrowsing);
        bt_facilityone=(Button) findViewById(R.id.bt_facilityone);
        bt_facilitytwo=(Button) findViewById(R.id.bt_facilitytwo);
        bt_playButtonmain=(Button) findViewById(R.id.bt_playButtonmain);
        bt_fullScreen=(Button) findViewById(R.id.bt_fullScreen);
        bt_uniformScreen=(Button) findViewById(R.id.bt_uniformScreen);
        bt_ProcAmp=(Button) findViewById(R.id.bt_ProcAmp);
        bt_RVC=(Button) findViewById(R.id.bt_RVC);
        bt_historicalStorage=(Button) findViewById(R.id.bt_historicalStorage);
        bt_superposition=(Button) findViewById(R.id.bt_superposition);
        bt_start=(Button) findViewById(R.id.bt_start);
        bt_fauna=(Button) findViewById(R.id.bt_fauna);
        bt_plateNumber=(Button) findViewById(R.id.bt_plateNumber);
        bt_exercise=(Button) findViewById(R.id.bt_exercise);
        bt_upward=(Button) findViewById(R.id.bt_upward);
        bt_wicket=(Button) findViewById(R.id.bt_wicket);
        bt_nail=(Button) findViewById(R.id.bt_nail);
        bt_upwardtwo=(Button) findViewById(R.id.bt_upwardtwo);
        bt_wickettwo=(Button) findViewById(R.id.bt_wickettwo);
        bt_nailtwo=(Button) findViewById(R.id.bt_nailtwo);
        bt_backMainBrowsingform=(Button) findViewById(R.id.bt_backMainBrowsingform);
        bt_alarm=(Button) findViewById(R.id.bt_alarm);
        bt_incident=(Button) findViewById(R.id.bt_incident);
        bt_backMainBrowsingformtwo=(Button) findViewById(R.id.bt_backMainBrowsingformtwo);
        bt_alarmtwo=(Button) findViewById(R.id.bt_alarmtwo);
        bt_incidenttwo=(Button) findViewById(R.id.bt_incidenttwo);


        tv_division=(TextView) findViewById(R.id.tv_division);
        tv_divisionRight=(TextView) findViewById(R.id.tv_divisionRight);
        tv_start=(TextView) findViewById(R.id.tv_start);
        tv_exercise=(TextView) findViewById(R.id.tv_exercise);
        tv_plateNumber=(TextView) findViewById(R.id.tv_plateNumber);
        tv_fauna=(TextView) findViewById(R.id.tv_fauna);
        tv_superposition=(TextView) findViewById(R.id.tv_superposition);
        tv_left=(TextView) findViewById(R.id.tv_left);

        vv_cameraone=(VideoView) findViewById(R.id.vv_cameraone);
        vv_cameratwo=(VideoView) findViewById(R.id.vv_cameratwo);

        rl_closeForm=(RelativeLayout) findViewById(R.id.rl_closeForm);
        rl_openForm=(RelativeLayout) findViewById(R.id.rl_openForm);
        rl_topbrowsing=(RelativeLayout) findViewById(R.id.rl_topbrowsing);
       // rl_SuperpositionOfImages=(RelativeLayout) findViewById(R.id.rl_SuperpositionOfImages);
        rl_topbrowsingform=(RelativeLayout) findViewById(R.id.rl_topbrowsingform);
        rl_topbrowsingformtwo=(RelativeLayout) findViewById(R.id.rl_topbrowsingformtwo);
        rl_ControlPicture=(RelativeLayout) findViewById(R.id.rl_ControlPicture);
        rl_seeks=(RelativeLayout) findViewById(R.id.rl_seeks);

        ll_btnPage=(LinearLayout) findViewById(R.id.ll_btnPage);
        LL_form=(LinearLayout) findViewById(R.id.LL_form);
        ll_superposition=(LinearLayout) findViewById(R.id.ll_superposition);

        ll_downwardOperatingBox=(LinearLayout) findViewById(R.id.ll_downwardOperatingBox);
        ll_videodisplayFrame=(LinearLayout) findViewById(R.id.ll_videodisplayFrame);
        ll_middleLayout=(LinearLayout) findViewById(R.id.ll_middleLayout);
        LL_formtwo=(LinearLayout) findViewById(R.id.LL_formtwo);
        ll_shipin_browsing=(LinearLayout)findViewById(R.id.ll_shipin_browsing);

        lv_forms=(ListView) findViewById(R.id.lv_forms);
        lv_formsIncident=(ListView) findViewById(R.id.lv_formsIncident);

        bt_backMainBrowsing.setOnClickListener(this);
        bt_facilityone.setOnClickListener(this);
        bt_facilitytwo.setOnClickListener(this);
        bt_playButtonmain.setOnClickListener(this);
        bt_fullScreen.setOnClickListener(this);
        bt_uniformScreen.setOnClickListener(this);
        bt_ProcAmp.setOnClickListener(this);
        bt_RVC.setOnClickListener(this);
        bt_historicalStorage.setOnClickListener(this);
        bt_superposition.setOnClickListener(this);
        bt_start.setOnClickListener(this);
        bt_fauna.setOnClickListener(this);
        bt_plateNumber.setOnClickListener(this);
        bt_exercise.setOnClickListener(this);
        bt_upward.setOnClickListener(this);
        bt_wicket.setOnClickListener(this);
        bt_nail.setOnClickListener(this);
        bt_upwardtwo.setOnClickListener(this);
        bt_wickettwo.setOnClickListener(this);
        bt_nailtwo.setOnClickListener(this);
        bt_backMainBrowsingform.setOnClickListener(this);
        bt_alarm.setOnClickListener(this);
        bt_incident.setOnClickListener(this);
        bt_backMainBrowsingformtwo.setOnClickListener(this);
        bt_alarmtwo.setOnClickListener(this);
        bt_incidenttwo.setOnClickListener(this);

        vv_cameraone.setOnClickListener(this);
        vv_cameratwo.setOnClickListener(this);

        ll_videodisplayFrame.setOnClickListener(this);
        LL_form.setOnClickListener(this);
        rl_seeks.setOnClickListener(this);

        //透明度
        //rl_ControlPicture.getBackground().setAlpha(53);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_backMainBrowsing://返回上层
                finish();
                break;
            case R.id.bt_facilityone://摄像头1
                facilityName();
                break;
            case R.id.bt_facilitytwo://摄像头2
                facilityNameTwo();
                break;
            case R.id.bt_playButtonmain://总开始按钮，如：点击开始在次点击暂停
                overallSwitch();
                break;
            case R.id.bt_fullScreen://全屏
                fullScreenName();

                break;
            case R.id.bt_uniformScreen://分屏 注：两个显示屏
                uniformScreenName();
                break;
            case R.id.bt_ProcAmp://单屏
               procAmpName();
                break;
            case R.id.bt_RVC://实时视频
                break;
            case R.id.bt_historicalStorage://历史存储
                break;
            case R.id.bt_superposition://事件画面叠加
                superposition();
                break;
            case R.id.bt_start://启动
                startName();
                break;
            case R.id.bt_fauna://物类
                faunaName();
                break;
           case R.id.bt_plateNumber://车牌
                plateNumber();
                break;
            case R.id.bt_exercise://运动
                exerciseBackground();
                break;
            case R.id.bt_upward://向上
                upward();
                break;
            case R.id.bt_wicket://隐藏表单的窗口

                break;
            case R.id.bt_nail://钉子
                break;
            case R.id.bt_upwardtwo://向下
                reveal();
                break;
            case R.id.bt_wickettwo://显示表单是的窗口
                wicketTwoName();
                break;
            case R.id.ll_videodisplayFrame://视频显示框
                dblclick();
                break;
            case R.id.bt_backMainBrowsingform://全屏表单时的返回按钮
            case R.id.bt_backMainBrowsingformtwo:
                backMainBrowsing();

                break;
           case R.id.bt_alarm://告警
                INCIDENT=0;
                formListView();
                break;
            case R.id.bt_incident://事件
                INCIDENT=1;
                formListView();
                break;
            case R.id.bt_alarmtwo://告警放大后表单
                INCIDENT=0;
                formListView();
                break;
            case R.id.bt_incidenttwo://事件放大后表单
                INCIDENT=1;
                formListView();
                break;
        }
    }
    //总开关，点击改变背景色
    public void overallSwitch(){
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
        if (swith==false){
            tv_start.setTextColor(shallowBlue);
            bt_playButtonmain.setBackgroundResource(R.drawable.stopplaying);
            swith=true;
        }else {
            tv_start.setTextColor(lightGray);
            bt_playButtonmain.setBackgroundResource(R.drawable.startplaying);
            swith=false;
        }
    }
    //运动
    public void exerciseBackground(){
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
            if (false==exercise&&false==startStatus){
                tv_exercise.setTextColor(lightGray);
                bt_exercise.setBackgroundResource(R.drawable.tint_quadrangle);
                exercise=true;
            }else if(true==exercise&&false==startStatus){
                tv_exercise.setTextColor(shallowBlue);
                bt_exercise.setBackgroundResource(R.drawable.cyan_quadrangle);
                exercise=false;
            }
    }
    //车牌
    public void plateNumber(){
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
        if (false==plate&&false==startStatus){
            tv_plateNumber.setTextColor(lightGray);
            bt_plateNumber.setBackgroundResource(R.drawable.platenumber);
            plate=true;
        }else if(true==plate&&false==startStatus) {
            tv_plateNumber.setTextColor(shallowBlue);
            bt_plateNumber.setBackgroundResource(R.drawable.platenumbertwo);
            plate=false;
        }
    }
    //bt_backMainBrowsingform 表单上的返回事件
    public void backMainBrowsing(){
        rl_topbrowsingform.setVisibility(View.GONE);
        rl_topbrowsingformtwo.setVisibility(View.GONE);
        rl_topbrowsing.setVisibility(View.VISIBLE);
        ll_middleLayout.setVisibility(View.VISIBLE);
        ll_btnPage.setVisibility(View.VISIBLE);
        ll_downwardOperatingBox.setVisibility(View.VISIBLE);
        rl_closeForm.setVisibility(View.VISIBLE);
        ll_shipin_browsing.setVisibility(View.VISIBLE);
        rl_seeks.setVisibility(View.GONE);


    }
    //物类
    public void faunaName(){
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
        if (false==fauna&&false==startStatus){
            tv_fauna.setTextColor(shallowBlue);
            bt_fauna.setBackgroundResource(R.drawable.faunatwo);
            fauna=true;
        }else if(true==fauna&&false==startStatus){
            tv_fauna.setTextColor(lightGray);
            bt_fauna.setBackgroundResource(R.drawable.fauna);
            fauna=false;
        }
    }
    //叠加
    public void superposition(){
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
        if(false==superposition){
            tv_superposition.setTextColor(shallowBlue);
            bt_superposition.setBackgroundResource(R.drawable.overlaytwo);
            superposition=true;
        }else if(true==superposition) {
            tv_superposition.setTextColor(lightGray);
            bt_superposition.setBackgroundResource(R.drawable.overlay);
            superposition=false;
        }
    }

    //启动
    public void startName(){
  /*tv_exercise,tv_plateNumber,tv_fauna*/
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
        yellow=mContext.getResources().getColor(R.color.colorYellow);
        if (false==start){
            startStatus=true;
            bt_start.setBackgroundResource(R.drawable.yellow_elipse);
            tv_start.setTextColor(shallowBlue);
            tv_start.setText("启动");
            start=true;
            if (true==fauna){
                tv_fauna.setTextColor(yellow);
                bt_fauna.setBackgroundResource(R.drawable.faunaone);
            }if(false==plate){
                tv_plateNumber.setTextColor(yellow);
                bt_plateNumber.setBackgroundResource(R.drawable.platenumberone);
            }if(false==exercise){
                tv_exercise.setTextColor(yellow);
                bt_exercise.setBackgroundResource(R.drawable.green_quadranle);
            }
        }else {
            startStatus=false;
            if(false==fauna){
                tv_fauna.setTextColor(lightGray);
                bt_fauna.setBackgroundResource(R.drawable.fauna);
            }else{
                tv_fauna.setTextColor(shallowBlue);
                bt_fauna.setBackgroundResource(R.drawable.faunatwo);
            }
            if(false==plate){
                tv_plateNumber.setTextColor(shallowBlue);
                bt_plateNumber.setBackgroundResource(R.drawable.platenumbertwo);
            }else {
                tv_plateNumber.setTextColor(lightGray);
                bt_plateNumber.setBackgroundResource(R.drawable.platenumber);
            }
            if(false==exercise){
                tv_exercise.setTextColor(shallowBlue);
                bt_exercise.setBackgroundResource(R.drawable.cyan_quadrangle);
            }else {
                tv_exercise.setTextColor(lightGray);
                bt_exercise.setBackgroundResource(R.drawable.tint_quadrangle);
            }
            bt_start.setBackgroundResource(R.drawable.ellipse);

            tv_start.setTextColor(lightGray);
            tv_start.setText("关闭");
            start=false;
        }
    }

    //单屏操作
    public void procAmpName(){
        splitScreen=false;
        vv_cameratwo.setVisibility(View.GONE);
    }
    //双屏操作
    public void uniformScreenName(){
        splitScreen=true;
        vv_cameratwo.setVisibility(View.VISIBLE);
        tv_division.setVisibility(View.VISIBLE);

    }
    //全屏操作
    public void fullScreenName(){
        if (false==splitScreen){
            tv_division.setVisibility(View.GONE );
        }else {
            tv_division.setVisibility(View.VISIBLE );
        }
        tv_left.setVisibility(View.GONE);
        ll_shipin_browsing.setVisibility(View.GONE);
        rl_topbrowsing.setVisibility(View.GONE);
        ll_btnPage.setVisibility(View.GONE);
        ll_downwardOperatingBox.setVisibility(View.GONE);
        rl_openForm.setVisibility(View.GONE);
        LL_form.setVisibility(View.GONE);

        tv_divisionRight.setVisibility(View.GONE);
        fullScreen=true;
    }


    ////退出全屏双击事件
    public void dblclick(){
        ll_videodisplayFrame.setOnTouchListener(new OnDoubleClickListener(new OnDoubleClickListener.DoubleClickCallback() {
            @Override
            public void onDoubleClick() {
                if(true==fullScreen){
                    rl_topbrowsing.setVisibility(View.VISIBLE);

                    ll_btnPage.setVisibility(View.VISIBLE);
                    if(true==upward){
                        ll_downwardOperatingBox.setVisibility(View.VISIBLE);
                        LL_form.setVisibility(View.VISIBLE);
                    }else if(false==upward){
                        rl_openForm.setVisibility(View.VISIBLE);
                        LL_form.setVisibility(View.GONE);
                    }
                    rl_ControlPicture.setVisibility(View.VISIBLE);
                    ll_shipin_browsing.setVisibility(View.VISIBLE);
                    tv_left.setVisibility(View.VISIBLE);
                    tv_divisionRight.setVisibility(View.VISIBLE);
                    fullScreen=false;
                }
            }
        }));
    }
    //表单窗口最大化
    public void wicketTwoName(){
        ll_middleLayout.setVisibility(View.GONE);
        ll_btnPage.setVisibility(View.GONE);
        rl_closeForm.setVisibility(View.GONE);
        rl_topbrowsing.setVisibility(View.GONE);
        ll_downwardOperatingBox.setVisibility(View.GONE);
        rl_topbrowsingform.setVisibility(View.VISIBLE);
        rl_topbrowsingformtwo.setVisibility(View.VISIBLE);
        ll_shipin_browsing.setVisibility(View.GONE);
        rl_seeks.setVisibility(View.VISIBLE);
    }
    //退出窗口最大化
    public void  quitWicketMaximize(){
        LL_form.setOnTouchListener(new OnDoubleClickListener(new OnDoubleClickListener.DoubleClickCallback() {
            @Override
            public void onDoubleClick() {
                ll_middleLayout.setVisibility(View.VISIBLE);
                ll_btnPage.setVisibility(View.VISIBLE);
                rl_closeForm.setVisibility(View.VISIBLE);
                rl_topbrowsing.setVisibility(View.VISIBLE);
                ll_downwardOperatingBox.setVisibility(View.VISIBLE);
            }
        }));

    }
    //显示屏选中状态
    public void cameraShooting(){
        vv_cameraone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (false==DisplayStatus&&false==fullScreen){
                    Log.e(TAG, "cameraShooting: "+DisplayStatus);
                    vv_cameraone.setBackgroundResource(R.drawable.borberb);
                    DisplayStatus=true;
                }else if (true==DisplayStatus&&false==fullScreen) {
                    vv_cameraone.setBackgroundResource(R.drawable.frame);
                    DisplayStatus=false;
                }
                return false;
            }
        });
        vv_cameratwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (false==viewingScreen&&false==fullScreen){
                    Log.e(TAG, "cameraShooting: "+DisplayStatus);
                    vv_cameratwo.setBackgroundResource(R.drawable.borberb);
                    viewingScreen=true;
                }else if (true==viewingScreen && false==fullScreen){
                    vv_cameratwo.setBackgroundResource(R.drawable.frame);
                    viewingScreen=false;
                }
                return false;
            }
        });
    }
    //选着摄像头1
    public void facilityName(){
        //cameraState
        if(false==cameraState){

            bt_facilityone.setBackgroundResource(R.color.colorYellow);
            cameraState=true;
        }else {
            bt_facilityone.setBackgroundResource(R.color.colorBlueness);
            cameraState=false;
        }
        //plate number discern result
    }
    //选着摄像头2
    public void facilityNameTwo(){
        if (false==cameraStateTwo){
            bt_facilitytwo.setBackgroundResource(R.color.colorYellow);
            cameraStateTwo=true;
        }else {
            bt_facilitytwo.setBackgroundResource(R.color.colorBlueness);
            cameraStateTwo=false;
        }
    }
    //显示表单
    public void upward(){
        upward=true;
        LL_form.setVisibility(View.VISIBLE);
        rl_closeForm.setVisibility(View.VISIBLE);
        rl_openForm.setVisibility(View.GONE);
        rl_seeks.setVisibility(View.GONE);
        ll_downwardOperatingBox.setVisibility(View.VISIBLE);

    }
    //隐藏表单
    public void reveal(){
        upward=false;
        rl_closeForm.setVisibility(View.GONE);
        LL_form.setVisibility(View.GONE);
        LL_formtwo.setVisibility(View.GONE);
        ll_downwardOperatingBox.setVisibility(View.GONE);
        rl_openForm.setVisibility(View.VISIBLE);
        rl_seeks.setVisibility(View.GONE);
    }
    //获取表单数据信息
    public void formListView(){
        mContext = MainBrowsingInterfaceActivity.this;
        mData = new LinkedList<FormsParameter>();
        if(0==INCIDENT){
            bt_alarm.setBackgroundResource(R.color.colocBluenAnming);
            bt_alarmtwo.setBackgroundResource(R.color.colocBluenAnming);
            bt_incidenttwo.setBackgroundResource(R.color.colorLightGray);
            bt_incident.setBackgroundResource(R.color.colorLightGray);
            if (true==upward){
                LL_formtwo.setVisibility(View.GONE);
                LL_form.setVisibility(View.VISIBLE);
            }if(false==upward) {
                LL_formtwo.setVisibility(View.GONE);
                LL_form.setVisibility(View.GONE);
            }

            for (int i=0;i<INT_STATE_SHUJU;i++){
                mData.add(new FormsParameter("序号", "时间","事件源","物体类型","状态","车牌号","状态","图片"));
            }

            mFormsAdapter= new FormsAdapter((LinkedList<FormsParameter>) mData, mContext);
            lv_forms.setAdapter(mFormsAdapter);

            //设定任务
            new Timer().schedule(new TimeTaskScroll(this, lv_forms), 200, 200);
            lv_forms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    startActivity(new Intent().setClass(MainBrowsingInterfaceActivity.this,DetailsFormsActivity.class));
                    Toast.makeText(MainBrowsingInterfaceActivity.this, "第几条数据"+i, Toast.LENGTH_LONG).show();
                }
            });
        }if(1==INCIDENT){
            bt_alarm.setBackgroundResource(R.color.colorLightGray);
            bt_alarmtwo.setBackgroundResource(R.color.colorLightGray);
            bt_incident.setBackgroundResource(R.color.colocBluenAnming);
            bt_incidenttwo.setBackgroundResource(R.color.colocBluenAnming);
            for (int i=0;i<INT_STATE_SHUJU;i++){

                mData.add(new FormsParameter("时间", "时间","时间","时间","时间","时间","时间","时间"));
            }

            mFormsAdapter= new FormsAdapter((LinkedList<FormsParameter>) mData, mContext);

            if (true==upward){
                LL_formtwo.setVisibility(View.VISIBLE);
                LL_form.setVisibility(View.GONE);
            }if(false==upward) {
                LL_formtwo.setVisibility(View.GONE);
                LL_form.setVisibility(View.GONE);
            }

            lv_formsIncident.setAdapter(mFormsAdapter);
            //设定任务
            new Timer().schedule(new TimeTaskScroll(this, lv_formsIncident), 200, 200);
            lv_formsIncident.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    startActivity(new Intent().setClass(MainBrowsingInterfaceActivity.this,DetailsFormsActivity.class));
                    Toast.makeText(MainBrowsingInterfaceActivity.this, "第几条数据"+i, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
