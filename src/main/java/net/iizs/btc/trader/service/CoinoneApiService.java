package net.iizs.btc.trader.service;

import net.iizs.btc.trader.model.coinone.*;
import retrofit2.Call;
import retrofit2.http.*;

// Reference http://doc.coinone.co.kr/
public interface CoinoneApiService {
    /*
     * run as default currency, btc
     */
    @GET("/orderbook/")
    Call<OrderBook> getOrderBook();

    /*
     * currency = btc, bch, eth, etc, xrp, qtum, iota, ltc, btg
     */
    @GET("/orderbook/")
    Call<OrderBook> getOrderBook(@Query("currency") String currency);
}
