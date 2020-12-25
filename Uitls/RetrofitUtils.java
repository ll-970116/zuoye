package com.example.imitation.Uitls;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements INetWorkInterface {
    private static volatile RetrofitUtils retrofitUtils;
    private final Observable<ResponseBody> observable;

    public RetrofitUtils() {
        observable = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URLConstant.BASEURL)
                .build()
                .create(APiService.class)
                .get(URLConstant.NWELIST);

    }

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void getData(String url, INetCollBack<T> collBack) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] interfaces = collBack.getClass().getGenericInterfaces();

                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            T t = new Gson().fromJson(string, type);
                            collBack.onSuccess(t);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        collBack.onFail("网络异常：" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
