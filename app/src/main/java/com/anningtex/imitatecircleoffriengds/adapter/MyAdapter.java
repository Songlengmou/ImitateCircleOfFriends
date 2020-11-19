package com.anningtex.imitatecircleoffriengds.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.anningtex.imitatecircleoffriengds.R;
import com.anningtex.imitatecircleoffriengds.bean.Friend;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @Author Song
 */
public class MyAdapter extends BaseQuickAdapter<Friend, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<Friend> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Friend item) {
        helper.setOnClickListener(R.id.btn_liu, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
