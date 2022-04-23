package com.example.retrofit.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    public static final String API_PATH = "http://static.pipezero.com/covid/";

    private static final Retrofit retrofit = null;

    public static Retrofit getRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(API_PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
