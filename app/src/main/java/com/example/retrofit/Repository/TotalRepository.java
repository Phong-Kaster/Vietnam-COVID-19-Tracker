package com.example.retrofit.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.retrofit.Model.Container;
import com.example.retrofit.Model.Today;
import com.example.retrofit.Model.Total;
import com.example.retrofit.WebService.RetrofitInterface;
import com.example.retrofit.WebService.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TotalRepository {
    private static TotalRepository repository;

    public static TotalRepository getRepository()
    {
        if( repository == null)
            repository = new TotalRepository();

        return repository;
    }

    public MutableLiveData<Total> retrieveData()
    {
        MutableLiveData<Total> data = new MutableLiveData<>();
        /*Step 1*/
        Retrofit service = RetrofitService.getRetrofit();
        RetrofitInterface api = service.create(RetrofitInterface.class);


        /*Step 2*/
        Call<Container> container = api.retrieveData();
        container.enqueue(new Callback<Container>() {
            @Override
            public void onResponse(Call<Container> call, Response<Container> response) {
                Total total = response.body().getTotal();
                data.setValue(total);
            }

            @Override
            public void onFailure(Call<Container> call, Throwable t) {

            }
        });

        return data;
    }
}
