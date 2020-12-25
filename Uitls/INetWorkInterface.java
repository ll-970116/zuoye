package com.example.imitation.Uitls;

public interface INetWorkInterface {
    public <T> void getData(String url, INetCollBack<T> collBack);

}
