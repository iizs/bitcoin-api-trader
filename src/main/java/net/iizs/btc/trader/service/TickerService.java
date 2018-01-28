package net.iizs.btc.trader.service;

import net.iizs.btc.trader.model.TickerInput;
import net.iizs.btc.trader.model.TickerServiceStatus;
import net.iizs.btc.trader.model.TickerValue;

import java.util.List;

public interface TickerService {
    public void add(TickerInput input);

    public TickerValue getLast(String exchangeName, String currency);

    public List<TickerValue> getRecentValues(String exchangeName, String currency, int size);

    public TickerServiceStatus getStatus();
}
