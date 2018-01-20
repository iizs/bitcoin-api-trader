package net.iizs.btc.trader;

import net.iizs.btc.trader.service.BithumbApiService;
import net.iizs.btc.trader.service.BithumbApiServiceBuilder;
import net.iizs.btc.trader.service.CoinoneApiService;
import net.iizs.btc.trader.service.CoinoneApiServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BitcoinTraderApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BitcoinTraderApplication.class, args);
    }

    // Defined via command line
    @Value("${net.iizs.btc.bithumbtrader.secretkey}")
    private String bithumbSecretKey;

    @Value("${net.iizs.btc.bithumbtrader.apikey}")
    private String bithumbApiKey;


    @Bean
    public BithumbApiService getBithumbApiService() {
        return BithumbApiServiceBuilder.create()
                .apiKey(bithumbApiKey)
                .secretKey(bithumbSecretKey)
                .build();
    }

    @Bean
    public CoinoneApiService getCoinoneApiService() {
        return CoinoneApiServiceBuilder.create()
                .build();
    }
}
