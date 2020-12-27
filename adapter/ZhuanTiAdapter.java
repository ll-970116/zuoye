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

public class ZhuanTiAdapter extends DelegateAdapter.Adapter<ZhuanTiAdapter.holder> {
    private LinearLayoutHelper linearLayoutHelper;

    private Context context;

    public ZhuanTiAdapter(LinearLayoutHelper linearLayoutHelper, Context context) {
        this.linearLayoutHelper = linearLayoutHelper;

        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_zt, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class holder extends RecyclerView.ViewHolder {


        private final TextView tv;

        public holder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv_zt);

        }
    }
}
