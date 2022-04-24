package com.example.retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
* this class helpes us wrapping all data get from API: http://static.pipezero.com/covid/data.json
 *
 * Other classes as Information, Location,.... will wrap data matching with their properties.
* */
public class Container {
    private Total total;
    private Today today;

    @SerializedName("overview")
    @Expose
    private ArrayList<Overview> overviews = new ArrayList<>();
    private ArrayList<Location> locations = new ArrayList<>();

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public Today getToday() {
        return today;
    }

    public void setToday(Today today) {
        this.today = today;
    }

    public ArrayList<Overview> getOverviews() {
        return overviews;
    }

    public void setOverviews(ArrayList<Overview> overviews) {
        this.overviews = overviews;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }
}
