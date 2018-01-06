package net.iizs.btc.bithumbtrader;

import net.iizs.btc.bithumbtrader.model.Balance;
import net.iizs.btc.bithumbtrader.model.OrderBook;
import net.iizs.btc.bithumbtrader.model.RecentTransactions;
import net.iizs.btc.bithumbtrader.model.Ticker;
import net.iizs.btc.bithumbtrader.service.BithumbApiService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BithumbApiServiceTests {
    @Autowired
    private BithumbApiService bithumbApiService;

    @Test
    public void testGetTicker() throws IOException {
        Call<Ticker> call = bithumbApiService.getTicker("BTC");
        Response<Ticker> response = call.execute();

        Ticker ticker = response.body();
        System.out.println(ticker);
        assertEquals("0000", ticker.getStatus());
    }

    @Test
    public void testGetOrderBook() throws IOException {
        Call<OrderBook> call = bithumbApiService.getOrderBook("BTC");
        Response<OrderBook> response = call.execute();

        OrderBook orderBook = response.body();
        System.out.println(orderBook);
        assertEquals("0000", orderBook.getStatus());
    }

    @Test
    public void testGetRecentTransactions() throws IOException {
        Call<RecentTransactions> call = bithumbApiService.getRecentTransactions("BTC");
        Response<RecentTransactions> response = call.execute();

        RecentTransactions recentTransactions = response.body();
        System.out.println(recentTransactions);
        assertEquals("0000", recentTransactions.getStatus());
    }

    // Defined via command line
    @Value("${net.iizs.btc.bithumbtrader.secretkey}")
    private String secretKey;

    @Test
    public void testGetBalance() throws IOException {
        Call<Balance> call = bithumbApiService.getBalance();
        Response<Balance> response = call.execute();

        Balance balance = response.body();
        System.out.println(balance);
        //System.out.println(response.errorBody().string());

        assertEquals("0000", balance.getStatus());
    }
}
