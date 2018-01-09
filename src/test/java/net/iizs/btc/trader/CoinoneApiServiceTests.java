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
}
