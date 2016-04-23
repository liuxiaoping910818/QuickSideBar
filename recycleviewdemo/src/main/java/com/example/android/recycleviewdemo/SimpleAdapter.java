package com.example.android.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {


    private LayoutInflater mInfater;
    private Context context;
    protected List<String> mDatas;
    public SimpleAdapter(Context context,List<String> datas){

        this.mDatas=datas;
        this.context=context;
        mInfater=LayoutInflater.from(context);

    }

    public interface OnItemClickListener{

        void onItemClick(View view,int position);
        void onItemLongClick(View view ,int position);
    }

    private OnItemClickListener onItemClickListener;

    public  void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;


    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=mInfater.inflate(R.layout.item_simple_texview,parent,false);

        MyViewHolder myViewHoder=new MyViewHolder(view);
        return myViewHoder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.textView.setText(mDatas.get(position));

        if (onItemClickListener!=null){

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition=holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView,layoutPosition);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    int layoutPosition=holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView,layoutPosition);
                    return false;
                }
            });
        }

    }
    public  void add(int pos){

        mDatas.add("insert one");
        notifyItemInserted(pos);
    }
    public void deleteData(int pos){

        mDatas.remove(1);
        notifyItemRemoved(pos);

    }

    class MyViewHolder extends ViewHolder{


        TextView textView;

        public MyViewHolder(View view) {
            super(view);

            textView=(TextView) view.findViewById(R.id.item_simple);
        }
    }

}
