package com.example.imitation.Uitls;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APiService {
    //String BaseUrl = "https://cdwan.cn/api/index";

    @GET
    Observable<ResponseBody> get(@Url String url);

}
