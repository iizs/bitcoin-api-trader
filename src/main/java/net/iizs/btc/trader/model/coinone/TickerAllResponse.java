package net.iizs.btc.trader.model.coinone;

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
    }

    public TickerResponse getTicker(String currency) {
        return map.get(currency);
    }

    public void setBtc(TickerResponse tickerResponse) {
        map.put("btc", tickerResponse);
    }

    public void setBch(TickerResponse tickerResponse) {
        map.put("bch", tickerResponse);
    }

    public void setEth(TickerResponse tickerResponse) {
        map.put("eth", tickerResponse);
    }

    public void setEtc(TickerResponse tickerResponse) {
        map.put("etc", tickerResponse);
    }

    public void setXrp(TickerResponse tickerResponse) {
        map.put("xrp", tickerResponse);
    }

    public void setQtum(TickerResponse tickerResponse) {
        map.put("qtum", tickerResponse);
    }

    public void setIota(TickerResponse tickerResponse) {
        map.put("iota", tickerResponse);
    }

    public void setLtc(TickerResponse tickerResponse) {
        map.put("ltc", tickerResponse);
    }

    public void setBtg(TickerResponse tickerResponse) {
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
