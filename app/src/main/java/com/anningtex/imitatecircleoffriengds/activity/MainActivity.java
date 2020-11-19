package com.anningtex.imitatecircleoffriengds.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.anningtex.imitatecircleoffriengds.bean.Friend;
import com.anningtex.imitatecircleoffriengds.R;
import com.anningtex.imitatecircleoffriengds.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Song
 * desc:仿朋友圈 与 上传图片
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.appBar)
    AppBarLayout appBarLayout;
    @BindView(R.id.image1)
    ImageView imageView;

    private List<Friend> friendList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
            int color = Color.argb(200, 0, 0, 0);
            collapsingToolbar.setCollapsedTitleTextColor(color);
            if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) { //折叠状态
                collapsingToolbar.setTitle("朋友圈");
                imageView.setVisibility(View.GONE);
                collapsingToolbar.setCollapsedTitleGravity(Gravity.CENTER);//设置收缩后标题的位置
            } else { //非折叠状态
                collapsingToolbar.setTitle("");
                imageView.setVisibility(View.VISIBLE);
                collapsingToolbar.setExpandedTitleGravity(Gravity.CENTER);//设置展开后标题的位置
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 10; i++) {
            Friend friend = new Friend(i);
            friendList.add(friend);
        }
        MyAdapter adapter = new MyAdapter(R.layout.item_my_feed_back, friendList);
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.btn_photo)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, UpLoadActivity.class));
    }
}
