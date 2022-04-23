package com.example.retrofit.WebService;

import com.example.retrofit.Model.Container;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("data.json")
    Call<Container> retrieveData();
}
