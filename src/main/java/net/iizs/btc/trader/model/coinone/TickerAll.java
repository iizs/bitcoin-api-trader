package net.iizs.btc.trader.model.coinone;

import java.util.HashMap;
import java.util.Map;

public class TickerAll extends Response {
    private long timestamp;
    private Map<String, Ticker> map;

    public TickerAll() {
        map = new HashMap<>();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Ticker getTicker(String currency) {
        return map.get(currency);
    }

    public void setBtc(Ticker ticker) {
        map.put("btc", ticker);
    }

    public void setBch(Ticker ticker) {
        map.put("bch", ticker);
    }

    public void setEth(Ticker ticker) {
        map.put("eth", ticker);
    }

    public void setEtc(Ticker ticker) {
        map.put("etc", ticker);
    }

    public void setXrp(Ticker ticker) {
        map.put("xrp", ticker);
    }

    public void setQtum(Ticker ticker) {
        map.put("qtum", ticker);
    }

    public void setIota(Ticker ticker) {
        map.put("iota", ticker);
    }

    public void setLtc(Ticker ticker) {
        map.put("ltc", ticker);
    }

    public void setBtg(Ticker ticker) {
        map.put("btg", ticker);
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
