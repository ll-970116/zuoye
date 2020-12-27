package com.example.imitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.imitation.R;
import com.example.imitation.bean.HomeBean;

public class PeiJianCategoryListAdapter extends DelegateAdapter.Adapter<PeiJianCategoryListAdapter.Holeder> {
    private HomeBean homeBean;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    public PeiJianCategoryListAdapter(HomeBean homeBean, Context context, GridLayoutHelper gridLayoutHelper) {
        this.homeBean = homeBean;
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {

        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public Holeder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pjcategor, parent, false);
        return new Holeder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holeder holder, int position) {
        holder.tv_2.setText(homeBean.getData().getCategoryList().get(3).getGoodsList().get(position).getName());
        holder.tv_3.setText("￥" + homeBean.getData().getCategoryList().get(3).getGoodsList().get(position).getRetail_price());

        Glide.with(context).load(homeBean.getData().getCategoryList().get(3).getGoodsList().get(position).getList_pic_url());
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class Holeder extends ViewHolder {

        private final ImageView iv;
        private final TextView tv_2;
        private final TextView tv_3;

        public Holeder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv_pjcatetor);
            tv_2 = itemView.findViewById(R.id.tv_2);
            tv_3 = itemView.findViewById(R.id.tv_3);
        }
    }
}
