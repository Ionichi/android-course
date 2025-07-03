package com.ionichi.login;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CuacaRootModel {
    @SerializedName("list")
    private List<CuacaListModel> listModels;
    @SerializedName("city")
    private CuacaCityModel cityModel;

    public CuacaRootModel() {
    }

    public List<CuacaListModel> getListModels() {
        return listModels;
    }

    public void setListModels(List<CuacaListModel> listModels) {
        this.listModels = listModels;
    }

    public CuacaCityModel getCityModel() {
        return cityModel;
    }

    public void setCityModel(CuacaCityModel cityModel) {
        this.cityModel = cityModel;
    }
}
