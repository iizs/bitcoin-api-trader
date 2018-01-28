package net.iizs.btc.trader;

import net.iizs.btc.trader.model.TickerStatusResponse;
import net.iizs.btc.trader.model.TickerValue;
import net.iizs.btc.trader.service.TickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private TickerService tickerService;

    @RequestMapping("/api/public/ticker/status")
    public TickerStatusResponse tickerStatus() {
        TickerStatusResponse resp = new TickerStatusResponse();
        resp.setTickerServiceStatus(tickerService.getStatus());
        return resp;
    }
}
