package net.iizs.btc.trader.service;

import net.iizs.btc.trader.model.TickerInput;
import net.iizs.btc.trader.model.TickerValue;

public interface TickerService {
    public void add(TickerInput input);

    public TickerValue getLast(String exchangeName, String currency);
}
