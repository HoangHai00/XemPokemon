package com.example.jsonpokemon.model;

import com.google.gson.annotations.SerializedName;

public class Home {

    @SerializedName("front_default")
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
}
