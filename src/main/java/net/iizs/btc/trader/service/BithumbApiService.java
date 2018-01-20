package net.iizs.btc.trader.service;

import net.iizs.btc.trader.model.bithumb.*;
import retrofit2.Call;
import retrofit2.http.*;

// Reference https://www.bithumb.com/u1/US127
public interface BithumbApiService {
    /*
     * {currency} = BTC, ETH, DASH, LTC, ETC, XRP, BCH, XMR, ZEC, QTUM, BTG, EOS (기본값: BTC), ALL(전체)
     * 단, ALL은 응답 형태가 다르므로 이 함수로 처리할 수 없다.
     */
    @GET("/public/ticker/{currency}/")
    Call<TickerResponse> getTicker(@Path("currency") String currency);

    /*
     * {currency} = BTC, ETH, DASH, LTC, ETC, XRP, BCH, XMR, ZEC, QTUM, BTG, EOS (기본값: BTC), ALL(전체)
     * 단, ALL은 응답 형태가 다르므로 이 함수로 처리할 수 없다.
     */
    @GET("/public/orderbook/{currency}/")
    Call<OrderBookResponse> getOrderBook(@Path("currency") String currency);

    /*
     * {currency} = BTC, ETH, DASH, LTC, ETC, XRP, BCH, XMR, ZEC, QTUM, BTG, EOS (기본값: BTC), ALL(전체)
     * 단, ALL은 응답 형태가 다르므로 이 함수로 처리할 수 없다.
     */
    @GET("/public/recent_transactions/{currency}/")
    Call<RecentTransactionsResponse> getRecentTransactions(@Path("currency") String currency);

    @POST("/info/balance")
    Call<BalanceResponse> getBalance();

    @FormUrlEncoded
    @POST("/info/balance")
    Call<BalanceResponse> getBalance(@Field("currency") String currency);

    @POST("/info/account")
    Call<AccountResponse> getAccount();

    @FormUrlEncoded
    @POST("/info/account")
    Call<AccountResponse> getAccount(@Field("currency") String currency);
}
