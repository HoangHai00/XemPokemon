package com.example.jsonpokemon.model;

import com.google.gson.annotations.SerializedName;

public class Sprites {
    @SerializedName("other")
    private Other oTher;

    public Other getoTher() {
        return oTher;
    }

    public void setoTher(Other oTher) {
        this.oTher = oTher;
    }
}
