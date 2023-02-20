package com.example.jsonpokemon.api;

import com.example.jsonpokemon.model.ListPokemon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    // https://pokeapi.co/api/v2/pokemon/1/
    // tạo gson
    Gson gson = new GsonBuilder()
            .setDateFormat("YYYY-MM-dd")
            .create();

    // tạo Interceptor để gán header cho link api
    Interceptor interceptor = chain -> {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
//        builder.addHeader("Key", "mã header")
        return chain.proceed(builder.build());
    };

    // xem dạng lỗi khi loatding dữ liệu api
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // tạo okHttp để setTime out
    OkHttpClient.Builder okBuilder = new OkHttpClient.Builder()
            .readTimeout(100, TimeUnit.SECONDS)
            .connectTimeout(100,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor);

    // tạo api để kết nối link
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(okBuilder.build())
            .build()
            .create(ApiService.class);

    // call đuôi link
    @GET("pokemon/{id}/")
    Call<ListPokemon> listPokemonTest(@Path("id") int id);

    // link API: http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
//    @GET("live")
//    Call<ListPokemon> listPokemonCall(@Query("access_key") String access_key,
//                                      @Query("currencies") String currencies,
//                                      @Query("source") String source,
//                                      @Query("format") int format);
}
