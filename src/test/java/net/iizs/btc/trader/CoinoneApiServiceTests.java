package net.iizs.btc.trader;

import net.iizs.btc.trader.model.coinone.*;
import net.iizs.btc.trader.service.CoinoneApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger log = LoggerFactory.getLogger(CoinoneApiServiceTests.class);

    @Test
    public void testGetOrderBook() throws IOException {
        Call<OrderBookResponse> call = coinoneApiService.getOrderBook();
        Response<OrderBookResponse> response = call.execute();

        OrderBookResponse orderBookResponse = response.body();
        log.debug(orderBookResponse.toString());
        assertEquals(0, orderBookResponse.getErrorCode());

        call = coinoneApiService.getOrderBook("xrp");
        response = call.execute();

        orderBookResponse = response.body();
        log.debug(orderBookResponse.toString());
        assertEquals(0, orderBookResponse.getErrorCode());
    }

    @Test
    public void testGetRecentCompleteOrders() throws IOException {
        Call<RecentCompleteOrdersResponse> call = coinoneApiService.getRecentCompleteOrders();
        Response<RecentCompleteOrdersResponse> response = call.execute();

        RecentCompleteOrdersResponse recentCompleteOrdersResponse = response.body();
        log.debug(recentCompleteOrdersResponse.toString());
        assertEquals(0, recentCompleteOrdersResponse.getErrorCode());

        call = coinoneApiService.getRecentCompleteOrders("xrp");
        response = call.execute();

        recentCompleteOrdersResponse = response.body();
        log.debug(recentCompleteOrdersResponse.toString());
        assertEquals(0, recentCompleteOrdersResponse.getErrorCode());

        call = coinoneApiService.getRecentCompleteOrders("xrp", "day");
        response = call.execute();

        recentCompleteOrdersResponse = response.body();
        log.debug(recentCompleteOrdersResponse.toString());
        assertEquals(0, recentCompleteOrdersResponse.getErrorCode());
    }

    @Test
    public void testGetTicker() throws IOException {
        Call<TickerResponse> call = coinoneApiService.getTicker("xrp");
        Response<TickerResponse> response = call.execute();

        TickerResponse tickerResponse = response.body();
        log.debug(tickerResponse.toString());
        assertEquals(0, tickerResponse.getErrorCode());
    }

    @Test
    public void testGetTickerAll() throws IOException {
        Call<TickerAllResponse> call = coinoneApiService.getTickerAll();
        Response<TickerAllResponse> response = call.execute();

        TickerAllResponse tickerAllResponse = response.body();
        log.debug(tickerAllResponse.toString());
        assertEquals(0, tickerAllResponse.getErrorCode());
    }
}
