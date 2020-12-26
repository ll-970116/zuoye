package com.example.imitation.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.imitation.R;
import com.example.imitation.adapter.BannerListener;
import com.example.imitation.adapter.SousuoAdapter;
import com.example.imitation.base.BaseFragment;
import com.example.imitation.bean.HomeBean;
import com.example.imitation.constants.IConstants;
import com.example.imitation.presenter.HomePresenterImpl;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment<HomePresenterImpl> implements IConstants.IView {


    private RecyclerView rl;
    private VirtualLayoutManager layoutManager;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banner;
    private DelegateAdapter adapter;
    private SousuoAdapter sousuoAdapter;
    private LinearLayoutHelper bannerlayoutHelper;
    private BannerListener bannerlistener;

    @Override
    protected int ID() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initData() {


        presenter.getData();


    }

    private void initBannerLinerLayout(HomeBean homeBean) {

        bannerlayoutHelper = new LinearLayoutHelper();
        bannerlayoutHelper.setItemCount(1);
        bannerlayoutHelper.setPadding(10, 10, 10, 10);
        bannerlayoutHelper.setBgColor(0);
        bannerlayoutHelper.setMargin(10, 10, 10, 10);
        bannerlayoutHelper.setAspectRatio(1);

        bannerlistener = new BannerListener(bannerlayoutHelper, homeBean, getActivity());
    }

    @Override
    protected void initView(View view) {
        rl = view.findViewById(R.id.rl);
    }

    private void initSousuoLinerLayout() {

        linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(6);
        linearLayoutHelper.setPadding(10, 10, 10, 10);
        linearLayoutHelper.setMargin(10, 10, 10, 10);
        linearLayoutHelper.setBgColor(0);
        linearLayoutHelper.setAspectRatio(6);


        sousuoAdapter = new SousuoAdapter(linearLayoutHelper, getActivity());


    }

    @Override
    protected HomePresenterImpl add() {
        return new HomePresenterImpl();
    }

    @Override
    public void OnSuccess(HomeBean homeBean) {
        layoutManager = new VirtualLayoutManager(getActivity());
        rl.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rl.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        initSousuoLinerLayout();
        initBannerLinerLayout(homeBean);

        adapter = new DelegateAdapter(layoutManager, true);
        adapter.addAdapter(sousuoAdapter);
        adapter.addAdapter(bannerlistener);

        rl.setAdapter(adapter);
    }

    @Override
    public void onFail(String err) {
        Log.e("TAG", "onFail: " + err);
    }
}