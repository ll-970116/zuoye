package com.example.imitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.imitation.R;
import com.example.imitation.bean.HomeBean;

public class ChanneGridlayoutper extends DelegateAdapter.Adapter<ChanneGridlayoutper.Holder> {
    private GridLayoutHelper gridLayoutHelper;
    private HomeBean homeBean;
    private Context context;

    public ChanneGridlayoutper(GridLayoutHelper gridLayoutHelper, HomeBean homeBean, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.homeBean = homeBean;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_channer, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(homeBean.getData().getChannel().get(position).getIcon_url()).into(holder.iv);
        holder.tv.setText(homeBean.getData().getChannel().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final ImageView iv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_channer);
            tv = itemView.findViewById(R.id.tv_channer);
        }
    }
}
