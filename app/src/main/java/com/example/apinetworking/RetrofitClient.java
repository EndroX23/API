package com.example.apinetworking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String BASE_URL = "https://reqres.in/api/";
    static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if ( retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        return retrofit;


    }
}
