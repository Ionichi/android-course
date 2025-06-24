package com.ionichi.cuaca;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootModel {
    @SerializedName("list")
    private List<ListModel> listModels;
    @SerializedName("city")
    private CityModel cityModel;

    public RootModel() {
    }

    public List<ListModel> getListModels() {
        return listModels;
    }

    public void setListModels(List<ListModel> listModels) {
        this.listModels = listModels;
    }

    public CityModel getCityModel() {
        return cityModel;
    }

    public void setCityModel(CityModel cityModel) {
        this.cityModel = cityModel;
    }
}
