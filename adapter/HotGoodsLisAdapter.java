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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.imitation.R;
import com.example.imitation.bean.HomeBean;

public class HotGoodsLisAdapter extends DelegateAdapter.Adapter<HotGoodsLisAdapter.holder> {
    private LinearLayoutHelper linearLayoutHelper;
    private HomeBean homeBean;
    private Context context;

    public HotGoodsLisAdapter(LinearLayoutHelper linearLayoutHelper, HomeBean homeBean, Context context) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.homeBean = homeBean;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_hotgood, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Glide.with(context).load(homeBean.getData().getHotGoodsList().get(position).getList_pic_url()).into(holder.iv);
        holder.tv1.setText(homeBean.getData().getHotGoodsList().get(position).getName());
        holder.tv2.setText(homeBean.getData().getHotGoodsList().get(position).getGoods_brief());
        holder.tv3.setText("￥"+homeBean.getData().getHotGoodsList().get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class holder extends RecyclerView.ViewHolder {

        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final ImageView iv;

        public holder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_hotgood);
            tv1 = itemView.findViewById(R.id.tv_1);
            tv2 = itemView.findViewById(R.id.tv_2);
            tv3 = itemView.findViewById(R.id.tv_3);

        }
    }
}
