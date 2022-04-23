package com.example.retrofit.Model;

public class Information {
    private int death;
    private int treating;
    private int cases;
    private int recovered;

    public Information() {
    }

    public Information(int death, int treating, int cases, int recovered) {
        this.death = death;
        this.treating = treating;
        this.cases = cases;
        this.recovered = recovered;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getTreating() {
        return treating;
    }

    public void setTreating(int treating) {
        this.treating = treating;
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
}
