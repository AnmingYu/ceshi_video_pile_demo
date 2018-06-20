package com.example.administrator.videopiledemo.adapterGather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.videopiledemo.R;
import com.example.administrator.videopiledemo.entity.FormsParameter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

public class FormsAdapter extends BaseAdapter {
    private LinkedList<FormsParameter> mList;
    private Context mContext;
    private String TAG="FormsAdapter";

    public FormsAdapter(LinkedList<FormsParameter> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position % mList.size());
    }

    @Override
    public long getItemId(int position) {
        return position % mList.size();
    }
    /*private String ordinal;//序号
      private String  time;//时间
      private String event;//事件源
      private String genre;//物体类型
      private String state;//状态
      private String plateNumbers;//车牌号
      private String perch;//状态
      private String map;//图片
  */
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        FormsItem mFormsItem;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_forms,null);
            mFormsItem = new FormsItem();
            mFormsItem.ordinal = (TextView) convertView.findViewById(R.id.tv_ordinal);
            mFormsItem.time = (TextView) convertView.findViewById(R.id.tv_time);
            mFormsItem.event = (TextView) convertView.findViewById(R.id.tv_event);
            mFormsItem.genre = (TextView) convertView.findViewById(R.id.tv_genre);
            mFormsItem.state = (TextView) convertView.findViewById(R.id.tv_state);
            mFormsItem.plateNumbers = (TextView) convertView.findViewById(R.id.tv_plateNumbersItem);
            mFormsItem.perch = (TextView) convertView.findViewById(R.id.tv_perch);
            mFormsItem.map = (TextView) convertView.findViewById(R.id.tv_map);
            convertView.setTag(mFormsItem);
        }else {
            mFormsItem = (FormsItem)convertView.getTag();
        }

        mFormsItem.ordinal.setText(mList.get(position % mList.size()).getOrdinal());
        mFormsItem.time.setText(mList.get(position % mList.size()).getTime());
        mFormsItem.event.setText(mList.get(position % mList.size()).getEvent());
        mFormsItem.genre.setText(mList.get(position % mList.size()).getGenre());
        mFormsItem.state.setText(mList.get(position % mList.size()).getState());
        mFormsItem.plateNumbers.setText(mList.get(position % mList.size()).getPlateNumbers());
        mFormsItem.perch.setText(mList.get(position % mList.size()).getPerch());
        mFormsItem.map.setText(mList.get(position % mList.size()).getMap());

        return convertView;
    }
    public class FormsItem {
        TextView ordinal,time,event,genre,state,plateNumbers,perch,map;
    }
}
