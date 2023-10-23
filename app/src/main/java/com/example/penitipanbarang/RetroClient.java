package com.example.penitipanbarang;

import android.util.CloseGuard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetroClient {
        private static Retrofit retrofit = null;
        private static String BASE_URL = "https://api-loker.000webhostapp.com/api/";



    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
            return retrofit;
        }
}
