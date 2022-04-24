package com.example.retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Overview {

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("death")
    @Expose
    private Integer death;

    @SerializedName("treating")
    @Expose
    private Integer treating;

    @SerializedName("cases")
    @Expose
    private Integer cases;

    @SerializedName("recovered")
    @Expose
    private Integer recovered;

    @SerializedName("avgCases7day")
    @Expose
    private Integer avgCases7day;

    @SerializedName("avgRecovered7day")
    @Expose
    private Integer avgRecovered7day;

    @SerializedName("avgDeath7day")
    @Expose
    private Integer avgDeath7day;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    public Integer getTreating() {
        return treating;
    }

    public void setTreating(Integer treating) {
        this.treating = treating;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getAvgCases7day() {
        return avgCases7day;
    }

    public void setAvgCases7day(Integer avgCases7day) {
        this.avgCases7day = avgCases7day;
    }

    public Integer getAvgRecovered7day() {
        return avgRecovered7day;
    }

    public void setAvgRecovered7day(Integer avgRecovered7day) {
        this.avgRecovered7day = avgRecovered7day;
    }

    public Integer getAvgDeath7day() {
        return avgDeath7day;
    }

    public void setAvgDeath7day(Integer avgDeath7day) {
        this.avgDeath7day = avgDeath7day;
    }

}