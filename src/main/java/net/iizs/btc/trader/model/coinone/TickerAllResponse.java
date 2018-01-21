package net.iizs.btc.trader.model.coinone;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TickerAllResponse extends Response {
    private long timestamp;
    private Map<String, TickerResponse> map;

    public TickerAllResponse() {
        map = new HashMap<>();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        for ( TickerResponse r : map.values() ) {
            r.setTimestamp(this.timestamp);
        }
    }

    public Collection<TickerResponse> getAllTickers() {
        return Collections.unmodifiableCollection(this.map.values());
    }

    public TickerResponse getTicker(String currency) {
        return map.get(currency);
    }

    public void setBtc(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("btc", tickerResponse);
    }

    public void setBch(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("bch", tickerResponse);
    }

    public void setEth(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("eth", tickerResponse);
    }

    public void setEtc(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("etc", tickerResponse);
    }

    public void setXrp(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("xrp", tickerResponse);
    }

    public void setQtum(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("qtum", tickerResponse);
    }

    public void setIota(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("iota", tickerResponse);
    }

    public void setLtc(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("ltc", tickerResponse);
    }

    public void setBtg(TickerResponse tickerResponse) {
        tickerResponse.setTimestamp(this.timestamp);
        map.put("btg", tickerResponse);
    }

    @Override
    public String toString() {
        return "TickerAll{" +
                "result='" + getResult() + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMsg='" + getErrorMsg() + '\'' +
                ", timestamp=" + timestamp +
                ", map=" + map +
                '}';
    }
}
