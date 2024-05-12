package com.example.alankit_leads;

import static com.example.alankit_leads.MainActivity.api;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class RestrofitInstance {

    public static RestrofitInstance instance;
    RetrofitAPI apiInterface;


    RestrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();

        apiInterface = retrofit.create(RetrofitAPI.class);
    }

    public static RestrofitInstance getInstance() {
        if (instance == null) ;
        {
            instance = new RestrofitInstance();

        }
        return instance;

    }
}
