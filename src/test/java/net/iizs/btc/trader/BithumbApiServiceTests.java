package net.iizs.btc.trader;

import net.iizs.btc.trader.model.bithumb.*;
import net.iizs.btc.trader.service.BithumbApiService;

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
        Call<TickerResponse> call = bithumbApiService.getTicker("BTC");
        Response<TickerResponse> response = call.execute();

        TickerResponse tickerResponse = response.body();
        System.out.println(tickerResponse);
        assertEquals("0000", tickerResponse.getStatus());
    }

    @Test
    public void testGetOrderBook() throws IOException {
        Call<OrderBookResponse> call = bithumbApiService.getOrderBook("BTC");
        Response<OrderBookResponse> response = call.execute();

        OrderBookResponse orderBookResponse = response.body();
        System.out.println(orderBookResponse);
        assertEquals("0000", orderBookResponse.getStatus());
    }

    @Test
    public void testGetRecentTransactions() throws IOException {
        Call<RecentTransactionsResponse> call = bithumbApiService.getRecentTransactions("BTC");
        Response<RecentTransactionsResponse> response = call.execute();

        RecentTransactionsResponse recentTransactionsResponse = response.body();
        System.out.println(recentTransactionsResponse);
        assertEquals("0000", recentTransactionsResponse.getStatus());
    }

    // Defined via command line
    @Value("${net.iizs.btc.bithumbtrader.secretkey}")
    private String secretKey;

    @Test
    public void testGetBalance() throws IOException {
        Call<BalanceResponse> call = bithumbApiService.getBalance();
        Response<BalanceResponse> response = call.execute();

        BalanceResponse balanceResponse = response.body();
        System.out.println(balanceResponse);
        //System.out.println(response.errorBody().string());

        assertEquals("0000", balanceResponse.getStatus());

        call = bithumbApiService.getBalance("BCH");
        response = call.execute();

        balanceResponse = response.body();
        System.out.println(balanceResponse);
        //System.out.println(response.errorBody().string());

        assertEquals("0000", balanceResponse.getStatus());
    }

    @Test
    public void testGetAccount() throws IOException {
        Call<AccountResponse> call = bithumbApiService.getAccount();
        Response<AccountResponse> response = call.execute();

        AccountResponse accountResponse = response.body();
        System.out.println(accountResponse);
        //System.out.println(account.message);
        //System.out.println(response.errorBody().string());

        assertEquals("0000", accountResponse.getStatus());

        call = bithumbApiService.getAccount("BCH");
        response = call.execute();

        accountResponse = response.body();
        System.out.println(accountResponse);
        //System.out.println(response.errorBody().string());

        assertEquals("0000", accountResponse.getStatus());

    }
}
