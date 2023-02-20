package com.example.jsonpokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jsonpokemon.adapter.ListPokemonAdapder;
import com.example.jsonpokemon.api.ApiService;
import com.example.jsonpokemon.model.ListPokemon;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Boolean diaLog = true;
    public  int id = 1;
    public RecyclerView rcListTenPokemon;
    public ListPokemonAdapder listPokemonAdapder;
    public ArrayList<ListPokemon> hListPokemon = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_main);
        dialog.setCanceledOnTouchOutside(false);

        CountDownTimer countDownTimer = new CountDownTimer(100,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                dialog.show();
            }

            @Override
            public void onFinish() {
                for (int i = 1; i <= 1010; i++) {
//                    try {
//                        Thread.sleep(300);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    loatAPI(i);
                }
                dialog.cancel();

            }
        };

        countDownTimer.start();




    }


    // link API: http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=C&format=1
    public void loatAPI(int id){
        ApiService.apiService.listPokemonTest(id).enqueue(new Callback<ListPokemon>() {
            @Override
            public void onResponse(Call<ListPokemon> call, Response<ListPokemon> response) {
//                Toast.makeText(MainActivity.this, "Thành Công", Toast.LENGTH_SHORT).show();
                ListPokemon listPokemon = response.body();
                hListPokemon.add(new ListPokemon(listPokemon.getName(),listPokemon.getId()));
                listPokemonAdapder.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ListPokemon> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Lỗi lấy dữ liệu ", Toast.LENGTH_SHORT).show();

            }



        });
    }


    // ánh xạ view
    public void anhxa(){

        rcListTenPokemon = findViewById(R.id.recycleviewListTenPokemon);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcListTenPokemon.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        itemDecoration.setDrawable(drawable);
        rcListTenPokemon.addItemDecoration(itemDecoration);

        listPokemonAdapder = new ListPokemonAdapder(hListPokemon,this);
        rcListTenPokemon.setAdapter(listPokemonAdapder);
    }
}