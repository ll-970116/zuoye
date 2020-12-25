package com.example.imitation.base;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> extends AppCompatActivity {

    public V iview;
    public M imode;

    public BasePresenter(V iview) {
        this.iview = iview;
        imode = setImode();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        imode = null;
    }

    protected abstract M setImode();
}
