package net.iizs.btc.trader.model;

import net.iizs.btc.trader.service.TickerService;

import java.util.HashMap;
import java.util.Map;

public class TickerServiceStatus {
    private long lastUpdateTimestamp;
    private int tickerSize;
    private long tickerValuesSize;
    private Map<String, Map<String, TickerStatus>> tickerStatus;

    public TickerServiceStatus() {
        lastUpdateTimestamp = 0;
        tickerSize = 0;
        tickerValuesSize = 0;
        tickerStatus = new HashMap<>();
    }

    public void addTickerStatus(String exchangeName, String currency, TickerStatus status) {
        Map<String, TickerStatus> currencyMap = tickerStatus.get(exchangeName);

        if ( currencyMap == null ) {
            currencyMap = new HashMap<>();
            tickerStatus.put(exchangeName, currencyMap);
        }

        TickerStatus previousStatus = currencyMap.put(currency, status);
        if ( previousStatus == null ) {
            // this call is for a new exahcnge and new currency
            tickerSize += 1;
        }
    }

    public long getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(long lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public int getTickerSize() {
        return tickerSize;
    }

    public void setTickerSize(int size) {
        this.tickerSize = size;
    }

    public long getTickerValuesSize() {
        return tickerValuesSize;
    }

    public void setTickerValuesSize(long tickerValuesSize) {
        this.tickerValuesSize = tickerValuesSize;
    }

    public Map<String, Map<String, TickerStatus>> getTickerStatus() {
        return tickerStatus;
    }

    @Override
    public String toString() {
        return "TickerServiceStatus{" +
                "lastUpdateTimestamp=" + lastUpdateTimestamp +
                ", tickerSize=" + tickerSize +
                ", tickerValuesSize=" + tickerValuesSize +
                ", tickerStatus=" + tickerStatus +
                '}';
    }
}
