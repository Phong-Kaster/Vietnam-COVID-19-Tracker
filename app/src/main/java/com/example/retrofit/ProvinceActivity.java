package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit.Model.Container;
import com.example.retrofit.Model.Location;
import com.example.retrofit.RecycleView.ProvinceRecycleView;
import com.example.retrofit.WebService.RetrofitInterface;
import com.example.retrofit.WebService.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProvinceActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);

        establishRetrofit();
    }



    private void establishRetrofit() {
        /*Step 1*/
        Retrofit service = RetrofitService.getRetrofit();
        RetrofitInterface api = service.create(RetrofitInterface.class);


        /*Step 2*/
        Call<Container> container = api.retrieveData();
        container.enqueue(new Callback<Container>() {
            @Override
            public void onResponse(Call<Container> call, Response<Container> response) {
                ArrayList<Location> locations = response.body().getLocations();


                establishControl(locations);
            }

            @Override
            public void onFailure(Call<Container> call, Throwable t) {

            }
        });
    }

    private void establishControl(ArrayList<Location> locations) {

        RecyclerView recyclerView = findViewById(R.id.provinceRecycleView);

        ProvinceRecycleView adapter = new ProvinceRecycleView(this, locations);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }
}