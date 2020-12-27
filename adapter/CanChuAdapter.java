package com.example.imitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.imitation.R;
import com.example.imitation.bean.HomeBean;

public class CanChuAdapter extends DelegateAdapter.Adapter<CanChuAdapter.holder> {
    private LinearLayoutHelper linearLayoutHelper;
    HomeBean homeBean;
    private Context context;


    public CanChuAdapter(LinearLayoutHelper linearLayoutHelper, HomeBean homeBean, Context context) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.layout_cc, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv.setText(homeBean.getData().getCategoryList().get(1).getName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class holder extends RecyclerView.ViewHolder {


        private final TextView tv;

        public holder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);

        }
    }
}
