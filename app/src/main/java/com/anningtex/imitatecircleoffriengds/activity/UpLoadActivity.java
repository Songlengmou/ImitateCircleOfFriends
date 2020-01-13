package com.anningtex.imitatecircleoffriengds.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;

import com.anningtex.imitatecircleoffriengds.bean.FeedBackPhotoBean;
import com.anningtex.imitatecircleoffriengds.R;
import com.anningtex.imitatecircleoffriengds.adapter.UpLoadImgListAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * @author Song
 * desc:上传图片留言界面
 */
public class UpLoadActivity extends AppCompatActivity {
    @BindView(R.id.rlPhotoList)
    RecyclerView rlPhotoList;

    private List<FeedBackPhotoBean> list = new ArrayList<>();
    private int REQUEST_IMAGE = 1;
    private ArrayList<String> defaultDataArray = new ArrayList<>();
    private List<File> mFiles;
    private UpLoadImgListAdapter upLoadImgListAdapter;
    private ArrayList<String> annexUrlList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_up_load);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        rlPhotoList.setLayoutManager(new GridLayoutManager(this, 3));
        upLoadImgListAdapter = new UpLoadImgListAdapter();
        FeedBackPhotoBean feedBackPhotoBean = new FeedBackPhotoBean();
        list.add(feedBackPhotoBean);
        upLoadImgListAdapter.setData(list);
        rlPhotoList.setAdapter(upLoadImgListAdapter);
        upLoadImgListAdapter.setiOnItemClickListener(new UpLoadImgListAdapter.IOnItemClickListener() {
            @Override
            public void addPhoto() {
                selectPic();
            }

            @Override
            public void lookPhoto(int position) {
                annexUrlList.clear();
                for (int i = 0; i < list.size() - 1; i++) {
                    annexUrlList.add(list.get(i).getPathImg());
                }
                Log.e("图片集合", annexUrlList.size() + "");
                for (int m = 0; m < annexUrlList.size(); m++) {
                    Log.e("图片", annexUrlList.get(m));
                }
                Intent intent = new Intent(UpLoadActivity.this, ImagePagerActivity.class);
                intent.putStringArrayListExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, annexUrlList);
                intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, position);
                startActivity(intent);
            }
        });
    }

    private void selectPic() {
        defaultDataArray.clear();
        Intent intent = new Intent(this, MultiImageSelectorActivity.class);
        // 是否显示调用相机拍照
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
        // 最大图片选择数量
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 9);
        // 设置模式 (支持 单选/MultiImageSelectorActivity.MODE_SINGLE 或者 多选/MultiImageSelectorActivity.MODE_MULTI)
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
        // 默认选择图片,回填选项(支持String ArrayList)
        intent.putStringArrayListExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, defaultDataArray);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (data != null) {
                defaultDataArray = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                if (defaultDataArray.size() > 0) {
                    mFiles = compressPic(defaultDataArray);
                    if (mFiles.size() > 0) {
                        for (File file : mFiles) {
                            // uploadImages(file);
                            onGetPhotoResult(file);
                        }
                    }
                }
            }
        }
    }

    private void onGetPhotoResult(File file) {
        FeedBackPhotoBean feedBackPhotoBean = list.get(upLoadImgListAdapter.getItemCount() - 1);
        feedBackPhotoBean.setPathImg(file.getAbsolutePath());
        feedBackPhotoBean.setAdd(false);
        if (upLoadImgListAdapter.getItemCount() < 9) {
            FeedBackPhotoBean feedBackPhotoBean1 = new FeedBackPhotoBean();
            list.add(feedBackPhotoBean1);
        }
        upLoadImgListAdapter.notifyDataSetChanged();
    }

    private List<File> compressPic(ArrayList<String> path) {
        try {
            Luban.Builder builder = Luban.with(this).ignoreBy(100).load(path).setCompressListener(new OnCompressListener() {
                @Override
                public void onStart() {
                }

                @Override
                public void onSuccess(File file) {
                    Log.e("压缩后的图片", file.toString());
                }

                @Override
                public void onError(Throwable throwable) {
                }
            });
            List<File> files = builder.get();
            builder.launch();
            return files;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
