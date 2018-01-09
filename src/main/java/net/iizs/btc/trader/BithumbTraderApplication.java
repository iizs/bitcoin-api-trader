package net.iizs.btc.trader;

import net.iizs.btc.trader.service.BithumbApiService;
import net.iizs.btc.trader.service.BithumbApiServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BithumbTraderApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BithumbTraderApplication.class, args);
    }

    // Defined via command line
    @Value("${net.iizs.btc.bithumbtrader.secretkey}")
    private String secretKey;

    @Value("${net.iizs.btc.bithumbtrader.apikey}")
    private String apiKey;


    @Bean
    public BithumbApiService getBithumbApiService() {
        return BithumbApiServiceBuilder.create()
                .apiKey(apiKey)
                .secretKey(secretKey)
                .build();
    }
}
