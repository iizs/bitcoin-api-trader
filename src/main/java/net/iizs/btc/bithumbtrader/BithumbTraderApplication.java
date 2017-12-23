package net.iizs.btc.bithumbtrader;

import net.iizs.btc.bithumbtrader.service.BithumbApiService;
import net.iizs.btc.bithumbtrader.service.BithumbApiServiceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BithumbTraderApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BithumbTraderApplication.class, args);
    }

    @Bean
    public BithumbApiService getBithumbApiService() {
        return BithumbApiServiceBuilder.create().build();
    }
}
