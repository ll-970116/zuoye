package com.example.imitation.presenter;

import com.example.imitation.Uitls.INetCollBack;
import com.example.imitation.Uitls.URLConstant;
import com.example.imitation.base.BasePresenter;
import com.example.imitation.bean.HomeBean;
import com.example.imitation.constants.IConstants;
import com.example.imitation.model.HomeModelImpl;

public class HomePresenterImpl extends BasePresenter<IConstants.IView, IConstants.IModel> implements IConstants.IPresenter {


    public HomePresenterImpl(IConstants.IView iview) {
        super(iview);

    }

    @Override
    protected IConstants.IModel setImode() {
        return new HomeModelImpl();
    }

    @Override
    public void getData() {
        imode.getData(URLConstant.BASEURL, new INetCollBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                iview.OnSuccess(homeBean);
            }

            @Override
            public void onFail(String err) {
                iview.onFail(err);
            }
        });
    }
}
