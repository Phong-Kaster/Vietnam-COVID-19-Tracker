package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.retrofit.Model.Container;
import com.example.retrofit.Model.Location;
import com.example.retrofit.Model.Overview;
import com.example.retrofit.Model.Today;
import com.example.retrofit.Model.Total;
import com.example.retrofit.WebService.RetrofitInterface;
import com.example.retrofit.WebService.RetrofitService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends TabActivity {

    private ArrayList<Location> locations;
    private ArrayList<Overview> overviews;

    private Today today;
    private Total total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        establishTabhost();
        establishRetrofit();
    }

    private void establishTabhost() {
        TabHost tabHost = getTabHost();
        Intent intent ;

        /*TabSpec provinceActivity*/
        TabHost.TabSpec proviceTabSpec = tabHost.newTabSpec("tab1");
        proviceTabSpec.setIndicator("Provice");

        intent = new Intent(this, ProvinceActivity.class);
        proviceTabSpec.setContent(intent);
        tabHost.addTab(proviceTabSpec);


        /*TabSpec todayActivity*/
        TabHost.TabSpec todayTabSpec = tabHost.newTabSpec("tab2");
        todayTabSpec.setIndicator("Today");

        intent = new Intent(this, TodayActivity.class);
        todayTabSpec.setContent(intent);
        tabHost.addTab(todayTabSpec);

        /*TabSpec overviewActivity*/
        TabHost.TabSpec overviewTabSpec = tabHost.newTabSpec("tab2");
        overviewTabSpec.setIndicator("Overview");

        intent = new Intent(this, OverviewActivity.class);
        overviewTabSpec.setContent(intent);
        tabHost.addTab(overviewTabSpec);

        /*TabSpec totalActivity*/
        TabHost.TabSpec totalTabSpec = tabHost.newTabSpec("tab2");
        totalTabSpec.setIndicator("Total");

        intent = new Intent(this, TotalActivity.class);
        totalTabSpec.setContent(intent);
        tabHost.addTab(totalTabSpec);
    }

    /**
     * @author Phong-Kaster
     * this function set up a HTTP request to API to retrieve data from server to this application
     * */
    private void establishRetrofit()
    {
        /*Step 1*/
        Retrofit service = RetrofitService.getRetrofit();
        RetrofitInterface api = service.create(RetrofitInterface.class);



        /*Step 2*/
        Call<Container> container = api.retrieveData();
        container.enqueue(new Callback<Container>() {
            @Override
            public void onResponse(@NonNull Call<Container> call, @NonNull Response<Container> response) {

                if( !response.isSuccessful() )
                    return;

                assert response.body() != null;
                locations = response.body().getLocations();
                overviews = response.body().getOverviews();

                today = response.body().getToday();
                total = response.body().getTotal();
            }

            @Override
            public void onFailure(Call<Container> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}