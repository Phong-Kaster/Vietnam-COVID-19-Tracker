package com.example.retrofit.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.Model.Location;

import java.util.List;

public class ProvinceViewModel extends ViewModel {
    private MutableLiveData<List<Location>> locations;

    public LiveData<List<Location>> getLocations()
    {
        return this.locations;
    }

}
