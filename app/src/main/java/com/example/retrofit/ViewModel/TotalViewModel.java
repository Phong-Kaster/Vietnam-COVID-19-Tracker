package com.example.retrofit.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.Model.Total;
import com.example.retrofit.Repository.TotalRepository;

public class TotalViewModel extends ViewModel {
    private MutableLiveData<Total> total;
    private TotalRepository repository;

    public LiveData<Total> getTotal()
    {
        return this.total;
    }

    public void instanciate()
    {
        repository = TotalRepository.getRepository();
        this.total = repository.retrieveData();
    }
}
