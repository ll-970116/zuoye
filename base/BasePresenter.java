package com.example.imitation.base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    public V iview;
    public M imode;

    public void attch(V v) {
        iview = v;
        imode = setImode();
    }

    public void destroy() {
        iview = null;
        imode = null;
    }

    protected abstract M setImode();
}
