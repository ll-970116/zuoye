package com.example.imitation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.imitation.R;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    private P presenter;
    private Context context = getActivity();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(ID(), container, false);
        if (presenter == null){
            presenter =add();

        }

        initView();
        initData();
        return view;
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P add();

    protected abstract int ID();

}
