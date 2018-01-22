package net.iizs.btc.trader;

import net.iizs.btc.trader.model.TickerInput;
import net.iizs.btc.trader.model.TickerValue;
import net.iizs.btc.trader.model.coinone.TickerAllResponse;
import net.iizs.btc.trader.model.coinone.TickerResponse;
import net.iizs.btc.trader.service.CoinoneApiService;
import net.iizs.btc.trader.service.TickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collection;

@Component
public class ScheduledTasks {
    @Autowired
    private TickerService tickerService;

    @Autowired
    private CoinoneApiService coinoneApiService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final String [] COINONE_CURRENCIES = {
            "btc", "bch", "eth", "etc", "xrp", "qtum", "iota", "ltc", "btg"
    };

    // Run every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void updateTicker() {
        try {
            Call<TickerAllResponse> call = coinoneApiService.getTickerAll();
            Response<TickerAllResponse> response = call.execute();

            TickerAllResponse tickerAllResponse = response.body();

            for( TickerResponse r : tickerAllResponse.getAllTickers() ) {
                tickerService.add(r);
            }

            for ( String currency : COINONE_CURRENCIES ) {
                TickerValue value = tickerService.getLast("coinone", currency);
                log.info(value.toString());
            }

        } catch ( IOException e ) {
            log.error(e.getMessage());
        }

    }
}
