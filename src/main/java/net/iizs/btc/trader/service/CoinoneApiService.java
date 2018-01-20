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

    /*
     * run as default currency, btc and default period hour
     */
    @GET("/trades/")
    Call<RecentCompleteOrders> getRecentCompleteOrders();

    /*
     * currency = btc, bch, eth, etc, xrp, qtum, iota, ltc, btg
     * period defaults to hour
     */
    @GET("/trades/")
    Call<RecentCompleteOrders> getRecentCompleteOrders(@Query("currency") String currency);

    /*
     * currency = btc, bch, eth, etc, xrp, qtum, iota, ltc, btg
     * period = hour, day
     */
    @GET("/trades/")
    Call<RecentCompleteOrders> getRecentCompleteOrders(@Query("currency") String currency, @Query("period") String period);

    /*
     * currency = btc, bch, eth, etc, xrp, qtum, iota, ltc, btg
     * for all currency, use getTickerAll()
     */
    @GET("/ticker/")
    Call<Ticker> getTicker(@Query("currency") String currency);

    @GET("/ticker/?currency=all")
    Call<TickerAll> getTickerAll();
}
