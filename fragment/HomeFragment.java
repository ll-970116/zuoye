package com.example.imitation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imitation.R;
import com.example.imitation.base.BaseFragment;
import com.example.imitation.bean.HomeBean;
import com.example.imitation.constants.IConstants;
import com.example.imitation.presenter.HomePresenterImpl;

public class HomeFragment extends BaseFragment<HomePresenterImpl> implements IConstants.IView {




    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected HomePresenterImpl add() {
        return new HomePresenterImpl(this);
    }

    @Override
    protected int ID() {
        return R.layout.fragment_home;
    }

    @Override
    public void OnSuccess(HomeBean homeBean) {

    }

    @Override
    public void onFail(String err) {

    }
}