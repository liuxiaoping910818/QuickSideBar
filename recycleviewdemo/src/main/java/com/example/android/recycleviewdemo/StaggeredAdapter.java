package com.example.android.recycleviewdemo;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class StaggeredAdapter extends SimpleAdapter {


   /* private LayoutInflater mInfater;
    private Context context;
    private List<String> mDatas;*/

    private List<Integer> mHeights;
    public StaggeredAdapter(Context context,List<String> datas){

       super(context,datas);

        mHeights=new ArrayList<>();
        for (int i = 0; i < mDatas.size(); i++) {

            mHeights.add((int) (100+Math.random()*300));

        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();

        layoutParams.height=mHeights.get(position);
        holder.itemView.setLayoutParams(layoutParams);
        holder.textView.setText(mDatas.get(position));

    }

}
