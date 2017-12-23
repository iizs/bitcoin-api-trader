package net.iizs.btc.bithumbtrader;

import net.iizs.btc.bithumbtrader.model.Ticker;
import net.iizs.btc.bithumbtrader.service.BithumbApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BithumbApiServiceTests {
    @Autowired
    private BithumbApiService bithumbApiService;

    @Test
    public void testTicker() throws IOException {
        Call<Ticker> call = bithumbApiService.getTicker("BTC");
        Response<Ticker> response = call.execute();

        Ticker ticker = response.body();

        System.out.println(ticker.getStatus());
        System.out.println(ticker.getData().getOpeningPrice());
    }
}
