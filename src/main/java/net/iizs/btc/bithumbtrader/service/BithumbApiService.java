package net.iizs.btc.bithumbtrader.service;

import net.iizs.btc.bithumbtrader.model.Ticker;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// Reference https://www.bithumb.com/u1/US127
public interface BithumbApiService {
    @GET("public/ticker/{currency}/")
    Call<Ticker> getTicker(@Path("currency") String currency);
}
