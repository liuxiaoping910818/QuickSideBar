package com.example.android.recycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<String> mData;
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        adapter=new SimpleAdapter(this,mData);
        recyclerView.setAdapter(adapter);

        //转换成ListViewr的形式，定义布局管理器
        LinearLayoutManager linearLayOutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayOutManager);

        //设置RecycledView的Items的分隔线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //添加动画 效果
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //添加监听
        adapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(MainActivity.this,position+ "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position+"clikc", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
    }

    //初始化数据
    private void initData() {
        mData=new ArrayList<String>();

        for (int i = 'A'; i < 'z' ;i++) {

            mData.add(""+(char)i);

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
        switch (id){            //转换面Gridview形式的布局
            case R.id.action_gridview:

                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_listview: //转换成ListView形式的布局
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_hor_gridview: //转换成水平而已民的

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(10,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_ver_gridview:  //转换成垂直布局
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL));
                break;
            case R.id.action_staggered:  //增加瀑布形式

                Intent intent=new Intent(this,StaggeredActivity.class);
                startActivity(intent);
                break;
            case R.id.action_delete:

                adapter.deleteData(1);
                break;
            case R.id.action_add:
                adapter.add(1);
                break;
            default:
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
