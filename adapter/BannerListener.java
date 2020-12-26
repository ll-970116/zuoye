package com.example.imitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.imitation.R;
import com.example.imitation.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerListener extends DelegateAdapter.Adapter<BannerListener.Hodle> {
    private LinearLayoutHelper bannerlayoutHelp;
    HomeBean banner;
    private Context context;

    public BannerListener(LinearLayoutHelper bannerlayoutHelp,HomeBean banner, Context context) {
        this.bannerlayoutHelp = bannerlayoutHelp;
        this.banner = banner;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return bannerlayoutHelp;
    }

    @NonNull
    @Override
    public Hodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_banner, parent, false);
        return new Hodle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hodle holder, int position) {
        holder.ban.setImages(banner.getData().getBanner()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataDTO.BannerDTO bb = (HomeBean.DataDTO.BannerDTO) path;
                Glide.with(context).load(bb.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Hodle extends RecyclerView.ViewHolder {

        private final Banner ban;

        public Hodle(@NonNull View itemView) {
            super(itemView);

            ban = itemView.findViewById(R.id.banner);
        }
    }
}
