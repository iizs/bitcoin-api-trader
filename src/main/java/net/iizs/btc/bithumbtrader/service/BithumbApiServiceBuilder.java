package net.iizs.btc.bithumbtrader.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BithumbApiServiceBuilder {
    public static BithumbApiServiceBuilder create() {
        return new BithumbApiServiceBuilder();
    }

    private BithumbApiServiceBuilder() {  }

    public BithumbApiService build() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.bithumb.com/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        return retrofit.create(BithumbApiService.class);
    }
}
