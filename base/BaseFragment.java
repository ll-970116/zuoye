package com.example.imitation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    public P presenter;
    public Context context = getActivity();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(ID(), container, false);
        if (presenter == null){
            presenter =add();
            presenter.attch(this);
        }

        initView(view);
        initData();
        return view;
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract P add();

    protected abstract int ID();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
