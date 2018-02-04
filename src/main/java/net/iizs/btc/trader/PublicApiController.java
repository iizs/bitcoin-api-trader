package net.iizs.btc.trader;

import net.iizs.btc.trader.model.Ticker;
import net.iizs.btc.trader.model.TickerStatusResponse;
import net.iizs.btc.trader.model.TickerValue;
import net.iizs.btc.trader.model.TickerResponse;
import net.iizs.btc.trader.service.TickerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicApiController {
    private static final Logger log = LoggerFactory.getLogger(PublicApiController.class);

    @Autowired
    private TickerService tickerService;

    @RequestMapping(value="/ticker/status", method = RequestMethod.GET)
    public TickerStatusResponse tickerStatus() {
        TickerStatusResponse resp = new TickerStatusResponse();
        resp.setTickerServiceStatus(tickerService.getStatus());
        return resp;
    }

    @RequestMapping(value="/ticker/{exchangeName}/{currency}", method = RequestMethod.GET)
    public TickerResponse tickerValue(@PathVariable String exchangeName, @PathVariable String currency, @RequestParam(defaultValue = "5") int size) {
        TickerResponse resp = new TickerResponse();

        if ( exchangeName.equals("all") ) {
            if ( currency.equals("all") ) {
                resp.setTickers(tickerService.getTickers((String e, String c) -> true, size));
            } else {
                resp.setTickers(tickerService.getTickers((String e, String c) -> c.equals(currency), size));
            }
        } else {
            if ( currency.equals("all") ) {
                resp.setTickers(tickerService.getTickers((String e, String c) -> e.equals(exchangeName), size));
            } else {
                resp.setTickers(tickerService.getTickers((String e, String c) -> e.equals(exchangeName) && c.equals(currency), size));
            }
        }

        return resp;
    }
}
