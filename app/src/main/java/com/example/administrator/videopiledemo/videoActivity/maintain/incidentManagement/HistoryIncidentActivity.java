package com.example.administrator.videopiledemo.videoActivity.maintain.incidentManagement;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.administrator.videopiledemo.videoActivity.maintain.mainBrowsingInterface.MainBrowsingInterfaceActivity;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class HistoryIncidentActivity extends AppCompatActivity  implements View.OnClickListener{
    private Context mContext;
    private int shallowBlue;
    private int lightGray;
    private String TAG="HistoryIncidentActivity";
    private List<FormsParameter> mData = null;
    private static final int INT_STATE_SHUJU=10;
    private FormsAdapter mFormsAdapter;


    /*
    * swith 开关
    * splitScreen 全屏
    * */
    private Boolean swith=false,splitScreen=false,doubleScreen=false,upwardhistory=false;
    /*
    * rl_backhistory 顶部操作返回 rl_openFormhistory 隐藏表单操作框
    * ll_middleLayoutHistory 视频显示区域
    * ll_historycontrol 视频操作区域
    * ll_formsHistory   表单操作
    * ll_formsTitle 表单数据
    * rl_tophistorytwo 表单最大化时的顶部操作
    * rl_backhistorytwo 表单最大化时的顶部操作
    * ll_historyActivity 总布局
    * */
    private RelativeLayout rl_tophistory,rl_openFormhistory,rl_backhistory,rl_tophistorytwo,rl_backhistorytwo;
    private LinearLayout ll_middleLayoutHistory,ll_historycontrol,ll_formsHistory,ll_formsTitle,ll_historyActivity,ll_historyseek;
    private VideoView vv_cameraonehistory,vv_cameratwohistory;
    private EditText et_seekhistory;
    private ListView lv_history;
    private ImageView iv_maintainsosIncidenttwo;

    /*
    * tv_fanhuihistorytwo 表单顶部返回
    * */
    private TextView tv_fanhuihistory,tv_left,tv_divisionRight,tv_divisionzhong,tv_fanhuihistorytwo;
    /*
    * bt_backhinstory 返回
    * bt_playButtonmain 开始/暂停
    * bt_fullScreen 全屏
    * bt_uniformScreenhistory 双屏屏
    * bt_ProcAmp 单屏
    * bt_historicalStorage 历史事件bt_upwardhistory打开表单 bt_wickethistory 放大表单 tv_seekhistory搜索
    * bt_backhinstorytwo  表单返回事件
    * ll_historyseek 搜索
    * */
    private Button bt_backhinstory,bt_playButtonmainhistory,bt_fullScreenhistory,bt_uniformScreenhistory,bt_ProcAmphistory,bt_historicalStorage,
            bt_upwardhistory,bt_wickethistory,bt_seekhistory,bt_backhinstorytwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_incident);
        mContext= HistoryIncidentActivity.this;

        init();
        listViewForms();
    }
    public void init(){
        rl_tophistory=(RelativeLayout) findViewById(R.id.rl_tophistory);
        rl_backhistory=(RelativeLayout) findViewById(R.id.rl_backhistory);
        rl_tophistorytwo=(RelativeLayout) findViewById(R.id.rl_tophistorytwo);
        rl_backhistorytwo=(RelativeLayout) findViewById(R.id.rl_backhistorytwo);
        ll_historycontrol=(LinearLayout) findViewById(R.id.ll_historycontrol);
        ll_formsHistory=(LinearLayout) findViewById(R.id.ll_formsHistory);
        ll_formsTitle=(LinearLayout) findViewById(R.id.ll_formsTitle);
        ll_middleLayoutHistory=(LinearLayout) findViewById(R.id.ll_middleLayoutHistory);
        ll_historyActivity=(LinearLayout) findViewById(R.id.ll_historyActivity);
        ll_historyseek=(LinearLayout) findViewById(R.id.ll_historyseek);
        iv_maintainsosIncidenttwo=(ImageView) findViewById(R.id.iv_maintainsosIncidenttwo);
        lv_history=(ListView) findViewById(R.id.lv_history);

        tv_fanhuihistory=(TextView) findViewById(R.id.tv_fanhuihistory);
        tv_left=(TextView) findViewById(R.id.tv_left);
        tv_divisionRight=(TextView) findViewById(R.id.tv_divisionRight);
        tv_fanhuihistorytwo=(TextView) findViewById(R.id.tv_fanhuihistorytwo);

        tv_divisionzhong=(TextView) findViewById(R.id.tv_divisionzhong);
        vv_cameraonehistory=(VideoView) findViewById(R.id.vv_cameraonehistory);
        vv_cameratwohistory=(VideoView) findViewById(R.id.vv_cameratwohistory);

        bt_playButtonmainhistory=(Button) findViewById(R.id.bt_playButtonmainhistory);
        bt_fullScreenhistory=(Button) findViewById(R.id.bt_fullScreenhistory);
        bt_uniformScreenhistory=(Button) findViewById(R.id.bt_uniformScreenhistory);
        bt_ProcAmphistory=(Button) findViewById(R.id.bt_ProcAmphistory);
        bt_upwardhistory=(Button) findViewById(R.id.bt_upwardhistory);
        bt_wickethistory=(Button) findViewById(R.id.bt_wickethistory);
        bt_backhinstorytwo=(Button) findViewById(R.id.bt_backhinstorytwo);


        rl_backhistory.setOnClickListener(this);
        rl_tophistorytwo.setOnClickListener(this);
        rl_backhistorytwo.setOnClickListener(this);


        tv_fanhuihistory.setOnClickListener(this);
        tv_left.setOnClickListener(this);
        tv_divisionRight.setOnClickListener(this);
        tv_divisionzhong.setOnClickListener(this);
        tv_fanhuihistorytwo.setOnClickListener(this);
        vv_cameraonehistory.setOnClickListener(this);
        vv_cameratwohistory.setOnClickListener(this);


        bt_playButtonmainhistory.setOnClickListener(this);
        bt_fullScreenhistory.setOnClickListener(this);
        bt_uniformScreenhistory.setOnClickListener(this);
        bt_ProcAmphistory.setOnClickListener(this);
        bt_upwardhistory.setOnClickListener(this);
        bt_wickethistory.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.rl_backhistory://返回上层
          case R.id.tv_fanhuihistory:
                finish();
                break;
          case R.id.bt_playButtonmainhistory://视频开关
              overallSwitch();
              break;
          case R.id.bt_fullScreenhistory://全屏
              fullScreen();
              break;
          case R.id.vv_cameraonehistory://双击退出全屏
              dblclick();
              break;
          case R.id.bt_uniformScreenhistory://双屏
              uniformScreenhistory();
              break;
          case R.id.bt_ProcAmphistory://单屏
              procAmphistory();
              break;
          case R.id.bt_upwardhistory://打开与隐藏标单
              upwardHistory();
              break;
          case R.id.bt_wickethistory://表单最大化
              wickethistory();
              break;
          case R.id.rl_backhistorytwo:
          case R.id.tv_fanhuihistorytwo://退出表单最大化
              backhistoryForms();
              break;

        }

    }
    //总开关，点击改变背景色
    public void overallSwitch(){
        shallowBlue=mContext.getResources().getColor(R.color.colorshallowBlue);
        lightGray=mContext.getResources().getColor(R.color.colorBlack);
        if (swith==false){
            bt_playButtonmainhistory.setBackgroundResource(R.drawable.stopplaying);
            swith=true;
        }else {
            bt_playButtonmainhistory.setBackgroundResource(R.drawable.startplaying);
            swith=false;
        }
    }
    //点击全屏
    public void fullScreen(){
        if (false==splitScreen){
            splitScreen=true;
            rl_tophistory.setVisibility(View.GONE);
            ll_historycontrol.setVisibility(View.GONE);
            ll_formsHistory.setVisibility(View.GONE);
            ll_formsTitle.setVisibility(View.GONE);
            tv_left.setVisibility(View.GONE);
            tv_divisionRight.setVisibility(View.GONE);
        }
    }
    ////退出全屏双击事件
    public void dblclick(){
        vv_cameraonehistory.setOnTouchListener(new OnDoubleClickListener(new OnDoubleClickListener.DoubleClickCallback() {
            @Override
            public void onDoubleClick() {
                if(true==splitScreen){
                    splitScreen=false;
                    rl_tophistory.setVisibility(View.VISIBLE);
                    ll_historycontrol.setVisibility(View.VISIBLE);
                    ll_formsHistory.setVisibility(View.VISIBLE);
                    ll_formsTitle.setVisibility(View.VISIBLE);
                    tv_left.setVisibility(View.VISIBLE);
                    tv_divisionRight.setVisibility(View.VISIBLE);

                }
            }
        }));
    }
    //双屏
    public void uniformScreenhistory(){

                if(false==doubleScreen){
                    doubleScreen=true;
                    vv_cameratwohistory.setVisibility(View.VISIBLE);
                    tv_divisionzhong.setVisibility(View.VISIBLE);
                }
    }
    //单屏
    public void procAmphistory(){
        if (true==doubleScreen){
            doubleScreen=false;
            vv_cameratwohistory.setVisibility(View.GONE);
            tv_divisionzhong.setVisibility(View.GONE);
        }
    }
    //显示/关闭表单
    public void upwardHistory(){
        if (false==upwardhistory){
            upwardhistory=true;
            bt_upwardhistory.setBackgroundResource(R.drawable.downward);
            ll_formsTitle.setVisibility(View.VISIBLE);
        }else if (true==upwardhistory){
            upwardhistory=false;
            bt_upwardhistory.setBackgroundResource(R.drawable.upward);
            ll_formsTitle.setVisibility(View.GONE);
        }

    }
    //表单最大化
    public void wickethistory(){
        if (true==upwardhistory){
            rl_tophistory.setVisibility(View.GONE);
            rl_tophistorytwo.setVisibility(View.VISIBLE);
            ll_middleLayoutHistory.setVisibility(View.GONE);
            ll_historycontrol.setVisibility(View.GONE);
            ll_formsHistory.setVisibility(View.GONE);
            ll_historyseek.setVisibility(View.VISIBLE);
            ll_historyActivity.setBackgroundResource(R.color.colorWhite);
            bt_backhinstorytwo.setBackgroundResource(R.drawable.backtracktwo);
            shallowBlue=mContext.getResources().getColor(R.color.colorBlueness);
            tv_fanhuihistorytwo.setTextColor(shallowBlue);
            iv_maintainsosIncidenttwo.setBackgroundResource(R.drawable.sostwo);
        }
    }
    //退出表单最大化
    public void backhistoryForms(){
        rl_tophistory.setVisibility(View.VISIBLE);
        rl_tophistorytwo.setVisibility(View.GONE);
        ll_middleLayoutHistory.setVisibility(View.VISIBLE);
        ll_historycontrol.setVisibility(View.VISIBLE);
        ll_formsHistory.setVisibility(View.VISIBLE);
        ll_historyseek.setVisibility(View.GONE);
        rl_backhistory.setVisibility(View.VISIBLE);
        ll_historyActivity.setBackgroundResource(R.drawable.pagesetting);

    }
    //listView获取数据
    public void listViewForms(){
        mData = new LinkedList<FormsParameter>();
        for (int i=0;i<INT_STATE_SHUJU;i++){
            mData.add(new FormsParameter("序号", "时间","事件源","物体类型","状态","车牌号","状态","图片"));
        }
        mFormsAdapter= new FormsAdapter((LinkedList<FormsParameter>) mData, mContext);
        lv_history.setAdapter(mFormsAdapter);
        //设定任务
        new Timer().schedule(new TimeTaskScroll(this, lv_history), 200, 200);
        lv_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HistoryIncidentActivity.this, "第几条数据"+i, Toast.LENGTH_LONG).show();
            }
        });

    }
}
