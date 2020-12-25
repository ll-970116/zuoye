package com.example.imitation.model;

import androidx.recyclerview.widget.RecyclerView;

import com.example.imitation.Uitls.INetCollBack;
import com.example.imitation.Uitls.RetrofitUtils;
import com.example.imitation.constants.IConstants;

public class HomeModelImpl implements IConstants.IModel {

    @Override
    public <T> void getData(String url, INetCollBack<T> collBack) {
        RetrofitUtils.getRetrofitUtils().getData(url,collBack);
    }
}
