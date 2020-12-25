package com.example.imitation.Uitls;

public interface INetCollBack<T> {

    public void  onSuccess(T t);
    public void onFail(String err);
}
