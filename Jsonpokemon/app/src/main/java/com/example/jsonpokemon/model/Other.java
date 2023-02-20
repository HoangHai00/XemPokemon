package com.example.jsonpokemon.model;

import com.google.gson.annotations.SerializedName;

public class Other {
    @SerializedName("home")
    private Home nha;

    public Home getNha() {
        return nha;
    }

    public void setNha(Home nha) {
        this.nha = nha;
    }
}
