package com.example.android.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class StaggeredActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<String> mDatas;
    private StaggeredAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initData();
        initView();

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        adapter=new StaggeredAdapter(this,mDatas);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));


        //
        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }

            @Override
            public void onItemLongClick(View view, int position) {
                adapter.deleteData(position);
            }
        });
    }

   private void initView() {

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
    }

    private void initData() {
        mDatas=new ArrayList<String>();

        for (int i = 'A'; i < 'z' ;i++) {

            mDatas.add(""+(char)i);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id){


        }
        return false;
    }
}
