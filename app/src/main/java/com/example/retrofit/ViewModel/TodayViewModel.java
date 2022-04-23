package com.example.retrofit.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.Model.Today;
import com.example.retrofit.Repository.TodayRepository;

public class TodayViewModel extends ViewModel {

    private MutableLiveData<Today> today;
    private TodayRepository repository;


    public LiveData<Today> getToday()
    {
        return this.today;
    }

    public void instanciate()
    {
        repository = TodayRepository.getRepository();
        this.today = repository.retrieveData();
    }
}
