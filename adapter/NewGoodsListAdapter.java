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

public class NewGoodsListAdapter extends DelegateAdapter.Adapter<NewGoodsListAdapter.Holder> {
    private GridLayoutHelper gridLayoutHelper;
    private HomeBean homeBean;
    private Context context;

    public NewGoodsListAdapter(GridLayoutHelper gridLayoutHelper, HomeBean homeBean, Context context) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.layout_newgoods, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(homeBean.getData().getNewGoodsList().get(position).getList_pic_url()).into(holder.iv);
        holder.tv2.setText(homeBean.getData().getNewGoodsList().get(position).getName());
        holder.tv3.setText(homeBean.getData().getNewGoodsList().get(position).getRetail_price()+"元起");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class Holder extends RecyclerView.ViewHolder {


        private final ImageView iv;
        private final TextView tv2;
        private final TextView tv3;

        public Holder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_newgoods);
            tv2 = itemView.findViewById(R.id.tv_2);
            tv3 = itemView.findViewById(R.id.tv_3);
        }
    }
}
