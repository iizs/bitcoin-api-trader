package net.iizs.btc.bithumbtrader.service;

import net.iizs.btc.bithumbtrader.model.Balance;
import net.iizs.btc.bithumbtrader.model.OrderBook;
import net.iizs.btc.bithumbtrader.model.RecentTransactions;
import net.iizs.btc.bithumbtrader.model.Ticker;
import retrofit2.Call;
import retrofit2.http.*;

// Reference https://www.bithumb.com/u1/US127
public interface BithumbApiService {
    /*
     * {currency} = BTC, ETH, DASH, LTC, ETC, XRP, BCH, XMR, ZEC, QTUM, BTG, EOS (기본값: BTC), ALL(전체)
     * 단, ALL은 응답 형태가 다르므로 이 함수로 처리할 수 없다.
     */
    @GET("/public/ticker/{currency}/")
    Call<Ticker> getTicker(@Path("currency") String currency);

    /*
     * {currency} = BTC, ETH, DASH, LTC, ETC, XRP, BCH, XMR, ZEC, QTUM, BTG, EOS (기본값: BTC), ALL(전체)
     * 단, ALL은 응답 형태가 다르므로 이 함수로 처리할 수 없다.
     */
    @GET("/public/orderbook/{currency}/")
    Call<OrderBook> getOrderBook(@Path("currency") String currency);

    /*
     * {currency} = BTC, ETH, DASH, LTC, ETC, XRP, BCH, XMR, ZEC, QTUM, BTG, EOS (기본값: BTC), ALL(전체)
     * 단, ALL은 응답 형태가 다르므로 이 함수로 처리할 수 없다.
     */
    @GET("/public/recent_transactions/{currency}/")
    Call<RecentTransactions> getRecentTransactions(@Path("currency") String currency);

    @POST("/info/balance")
    Call<Balance> getBalance();

    @FormUrlEncoded
    @POST("/info/balance")
    Call<Balance> getBalance(@Field("currency") String currency);
}
