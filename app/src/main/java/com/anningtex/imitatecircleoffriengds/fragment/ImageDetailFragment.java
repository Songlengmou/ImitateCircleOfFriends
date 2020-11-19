package com.anningtex.imitatecircleoffriengds.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.anningtex.imitatecircleoffriengds.R;
import com.anningtex.imitatecircleoffriengds.manger.MainApplication;
import com.bumptech.glide.Glide;

import photoview.PhotoViewAttacher;

/**
 * @author Song
 * desc:单张图片显示Fragment(点击放大效果)
 */
public class ImageDetailFragment extends Fragment {
    private String mImageUrl;
    private ImageView mImageView;
    private ProgressBar progressBar;
    private PhotoViewAttacher mAttacher;

    public static ImageDetailFragment newInstance(String imageUrl) {
        ImageDetailFragment fragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", imageUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments() != null ? getArguments().getString("url") : null;
        Log.e("图片路径", mImageUrl);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_detail_fragment, container, false);
        mImageView = view.findViewById(R.id.image);
        progressBar = view.findViewById(R.id.loading);
        mAttacher = new PhotoViewAttacher(mImageView);
        mAttacher.setOnPhotoTapListener((arg0, arg1, arg2) -> getActivity().finish());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(MainApplication.getContext()).load(mImageUrl).into(mImageView);
    }
}
