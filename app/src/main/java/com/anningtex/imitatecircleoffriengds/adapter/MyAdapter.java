package com.anningtex.imitatecircleoffriengds.adapter;

import android.support.annotation.Nullable;

import com.anningtex.imitatecircleoffriengds.bean.Friend;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @Author Song
 * @Desc:
 */
public class MyAdapter extends BaseQuickAdapter<Friend, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<Friend> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Friend item) {

    }
}
