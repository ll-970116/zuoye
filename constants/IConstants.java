package com.example.imitation.constants;

import com.example.imitation.Uitls.INetCollBack;
import com.example.imitation.base.BaseModel;
import com.example.imitation.base.BaseView;
import com.example.imitation.bean.HomeBean;

public interface IConstants {
    public interface IModel extends BaseModel {
        <T> void getData(String url, INetCollBack<T> collBack);

    }

    public interface IPresenter {
        void getData();
    }

    public interface IView extends BaseView {
        void OnSuccess(HomeBean homeBean);
        void onFail(String err);
    }
}
