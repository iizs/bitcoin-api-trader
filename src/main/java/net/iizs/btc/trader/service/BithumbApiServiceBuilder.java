package net.iizs.btc.trader.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import net.iizs.btc.trader.interceptor.BithumbAuthInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BithumbApiServiceBuilder {
    public static BithumbApiServiceBuilder create() {
        return new BithumbApiServiceBuilder();
    }

    private BithumbApiServiceBuilder() { }

    private String apiKey;
    private String secretKey;

    public BithumbApiServiceBuilder apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public BithumbApiServiceBuilder secretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    // I'll not re-use builder objects
    public BithumbApiService build() {
        // TODO throw exception if apiKey and secretKey did not set
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BithumbAuthInterceptor(apiKey, secretKey))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.bithumb.com")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        return retrofit.create(BithumbApiService.class);
    }
}
