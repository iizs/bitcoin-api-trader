package net.iizs.btc.trader;

import net.iizs.btc.trader.model.coinone.*;
import net.iizs.btc.trader.service.CoinoneApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinoneApiServiceTests {
    @Autowired
    private CoinoneApiService coinoneApiService;

    @Test
    public void testGetOrderBook() throws IOException {
        Call<OrderBook> call = coinoneApiService.getOrderBook();
        Response<OrderBook> response = call.execute();

        OrderBook orderBook = response.body();
        System.out.println(orderBook);
        assertEquals(0, orderBook.getErrorCode());

        call = coinoneApiService.getOrderBook("xrp");
        response = call.execute();

        orderBook = response.body();
        System.out.println(orderBook);
        assertEquals(0, orderBook.getErrorCode());
    }

    @Test
    public void testGetRecentCompleteOrders() throws IOException {
        Call<RecentCompleteOrders> call = coinoneApiService.getRecentCompleteOrders();
        Response<RecentCompleteOrders> response = call.execute();

        RecentCompleteOrders recentCompleteOrders = response.body();
        System.out.println(recentCompleteOrders);
        assertEquals(0, recentCompleteOrders.getErrorCode());

        call = coinoneApiService.getRecentCompleteOrders("xrp");
        response = call.execute();

        recentCompleteOrders = response.body();
        System.out.println(recentCompleteOrders);
        assertEquals(0, recentCompleteOrders.getErrorCode());

        call = coinoneApiService.getRecentCompleteOrders("xrp", "day");
        response = call.execute();

        recentCompleteOrders = response.body();
        System.out.println(recentCompleteOrders);
        assertEquals(0, recentCompleteOrders.getErrorCode());
    }

    @Test
    public void testGetTicker() throws IOException {
        Call<Ticker> call = coinoneApiService.getTicker("xrp");
        Response<Ticker> response = call.execute();

        Ticker ticker = response.body();
        System.out.println(ticker);
        assertEquals(0, ticker.getErrorCode());
    }

    @Test
    public void testGetTickerAll() throws IOException {
        Call<TickerAll> call = coinoneApiService.getTickerAll();
        Response<TickerAll> response = call.execute();

        TickerAll tickerAll = response.body();
        System.out.println(tickerAll);
        assertEquals(0, tickerAll.getErrorCode());
    }
}
