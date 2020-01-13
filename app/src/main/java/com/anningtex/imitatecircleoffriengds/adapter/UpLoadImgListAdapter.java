package com.anningtex.imitatecircleoffriengds.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anningtex.imitatecircleoffriengds.bean.FeedBackPhotoBean;
import com.anningtex.imitatecircleoffriengds.R;
import com.anningtex.imitatecircleoffriengds.manger.MainApplication;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author Song
 * desc:上传图片留言
 */
public class UpLoadImgListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FeedBackPhotoBean> lst;
    private int maxCount = 9;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());
        RecyclerView.ViewHolder holder;
        if (i == 1) {
            View v = mInflater.inflate(R.layout.item_upload_img_add, viewGroup, false);
            holder = new AddItemViewHolder(v);
        } else {
            View v = mInflater.inflate(R.layout.item_upload_img, viewGroup, false);
            holder = new PhotoItemViewHolder(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        FeedBackPhotoBean feedBackPhotoBean = lst.get(i);
        if (getItemViewType(i) == 1) {
            if (viewHolder instanceof AddItemViewHolder) {
                viewHolder.itemView.setOnClickListener(v -> {
                    if (iOnItemClickListener != null) {
                        iOnItemClickListener.addPhoto();
                    }
                });
            }
        } else {
            if (viewHolder instanceof PhotoItemViewHolder) {
                Glide.with(MainApplication.getContext()).load(feedBackPhotoBean.getPathImg()).into(((PhotoItemViewHolder) viewHolder).img_photo);
                ((PhotoItemViewHolder) viewHolder).img_delete.setOnClickListener(v -> {
                    boolean add = false;
                    if ((viewHolder.getLayoutPosition() == (maxCount - 1) &&
                            getItemCount() == maxCount && !lst.get(viewHolder.getLayoutPosition()).isAdd())
                            || (viewHolder.getLayoutPosition() < (maxCount - 1)
                            && !lst.get(getItemCount() - 1).isAdd())) {
                        add = true;
                    }
                    lst.remove(viewHolder.getLayoutPosition());
                    if (add) {
                        FeedBackPhotoBean feedBackPhotoBean1 = new FeedBackPhotoBean();
                        lst.add(feedBackPhotoBean1);
                    }
                    notifyDataSetChanged();
                });

                ((PhotoItemViewHolder) viewHolder).img_photo.setOnClickListener(v -> {
                    if (iOnItemClickListener != null) {
                        iOnItemClickListener.lookPhoto(viewHolder.getLayoutPosition());
                    }
                });
            }
        }
    }

    public void setData(List<FeedBackPhotoBean> lst) {
        this.lst = lst;
    }

    @Override
    public int getItemViewType(int position) {
        if (lst.get(position).isAdd()) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        if (lst == null) {
            return 0;
        }
        return lst.size();
    }

    class PhotoItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_photo;
        private ImageView img_delete;

        public PhotoItemViewHolder(View itemView) {
            super(itemView);
            img_photo = itemView.findViewById(R.id.img_photo);
            img_delete = itemView.findViewById(R.id.img_delete);
        }
    }

    class AddItemViewHolder extends RecyclerView.ViewHolder {
        public AddItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setiOnItemClickListener(IOnItemClickListener iOnItemClickListener) {
        this.iOnItemClickListener = iOnItemClickListener;
    }

    public IOnItemClickListener iOnItemClickListener;

    public interface IOnItemClickListener {
        void addPhoto();

        void lookPhoto(int position);
    }
}
