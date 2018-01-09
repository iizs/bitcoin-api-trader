package net.iizs.btc.trader.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CoinoneApiServiceBuilder {
    public static CoinoneApiServiceBuilder create() {
        return new CoinoneApiServiceBuilder();
    }

    private CoinoneApiServiceBuilder() { }

    // I'll not re-use builder objects
    public CoinoneApiService build() {
        ObjectMapper objectMapper = new ObjectMapper();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.coinone.co.kr")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        return retrofit.create(CoinoneApiService.class);
    }
}
