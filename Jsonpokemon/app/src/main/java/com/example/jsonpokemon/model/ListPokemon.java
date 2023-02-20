package com.example.jsonpokemon.model;


import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class ListPokemon {
    private String name;
    private int id;

    public ListPokemon(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListPokemon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    }
    //    private String terms;
//    private long timestamp;
//
//    public ListPokemon(String terms, long timestamp) {
//        this.terms = terms;
//        this.timestamp = timestamp;
//    }
//
//    public String getTerms() {
//        return terms;
//    }
//
//    public void setTerms(String terms) {
//        this.terms = terms;
//    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    @Override
//    public String toString() {
//        return "ListPokemon{" +
//                "terms='" + terms + '\'' +
//                ", timestamp=" + timestamp +
//                '}';
//    }

