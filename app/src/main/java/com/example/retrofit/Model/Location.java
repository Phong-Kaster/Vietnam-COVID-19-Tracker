package com.example.retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("death")
    @Expose
    private int death;

    @SerializedName("treating")
    @Expose
    private int treatings;

    @SerializedName("cases")
    @Expose
    private int cases;

    @SerializedName("recovered")
    @Expose
    private int recovered;

    @SerializedName("casesToday")
    private int todayCases;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getTreatings() {
        return treatings;
    }

    public void setTreatings(int treatings) {
        this.treatings = treatings;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }
}
