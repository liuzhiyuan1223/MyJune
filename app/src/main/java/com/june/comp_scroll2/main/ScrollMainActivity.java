package com.june.comp_scroll2.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.june.R;
import com.june.comp_scroll2.PullToRefreshBase;
import com.june.comp_scroll2.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class ScrollMainActivity extends AppCompatActivity {

    private PullToRefreshListView pullToRefreshListView;
    private View headerview_in;
    private View headerview1;
    private View headerview2;
    private List<String> data;
    private int a = 10;
    private int b;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scroll);

        data = new ArrayList<>();

        headerview_in = findViewById(R.id.listview_headerview2);
        pullToRefreshListView = findViewById(R.id.listview);

        headerview1 = View.inflate(this, R.layout.listview_headerview1, null);
        headerview2 = View.inflate(this, R.layout.listview_headerview2, null);

        ListView listView = pullToRefreshListView.getRefreshableView();
        listView.addHeaderView(headerview1);
        listView.addHeaderView(headerview2);

        pullToRefreshListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                headerview_in.setVisibility(firstVisibleItem >= 2 ? View.VISIBLE : View.GONE);
            }
        });

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                b = 0;
                a = 10;
                data.clear();
                initData();
                myAdapter.initData(data);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message msg = new Message();
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }
                }).start();

            }
        });

        pullToRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                b = a;
                a = a + 10;
                initData();
                myAdapter.initData(data);
            }
        });

        initData();

        myAdapter = new MyAdapter(data, getApplicationContext());
        pullToRefreshListView.setAdapter(myAdapter);
    }

    //刷新数据
    private void initData() {
        for (int i = b; i < a; i++) {
            data.add("订单" + i);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            pullToRefreshListView.onRefreshComplete();
        }
    };
}
