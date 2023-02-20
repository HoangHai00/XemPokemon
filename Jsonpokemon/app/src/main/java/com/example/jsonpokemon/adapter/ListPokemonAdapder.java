package com.example.jsonpokemon.adapter;

import static android.service.controls.ControlsProviderService.TAG;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonpokemon.MainActivity;
import com.example.jsonpokemon.R;
import com.example.jsonpokemon.model.ListPokemon;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.http.Url;

public class ListPokemonAdapder extends RecyclerView.Adapter<ListPokemonAdapder.ListPokemonViewHolder>{

    private ArrayList<ListPokemon> hListPokemon;

    public ListPokemonAdapder(ArrayList<ListPokemon> hListPokemon, MainActivity mainActivity) {
        this.hListPokemon = hListPokemon;
    }

    @NonNull
    @Override
    public ListPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_pokemon, parent,false);

        return new ListPokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPokemonViewHolder holder, int position) {

        ListPokemon listPokemon = hListPokemon.get(position);
        if (listPokemon == null){
            return;
        }
        // Sắp xếp theo id
        Collections.sort(hListPokemon, new Comparator<ListPokemon>() {
            @Override
            public int compare(ListPokemon listPokemon, ListPokemon t1) {
                return listPokemon.getId()-t1.getId();
            }
        });
//        https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/1.png
        holder.txtID.setText(listPokemon.getId()+"");
        holder.txtTenPokemon.setText(listPokemon.getName());
        int id = position + 1;
        String linkAnh ="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/" +id+".png";
        Picasso.get().load(linkAnh.trim()).into(holder.imgAnhPokemon);
    }

    @Override
    public int getItemCount() {
        if (hListPokemon != null){
            return hListPokemon.size();
        }
        return 0;
    }

    public  class ListPokemonViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAnhPokemon;
        TextView txtTenPokemon,txtID;
        public ListPokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAnhPokemon = itemView.findViewById(R.id.imageViewPokemon);
            txtTenPokemon = itemView.findViewById(R.id.textViewTenPokemon);
            txtID = itemView.findViewById(R.id.textViewID);
        }
    }
}
