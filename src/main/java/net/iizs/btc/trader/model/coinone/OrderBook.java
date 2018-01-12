package net.iizs.btc.trader.model.coinone;

import java.util.List;

public class OrderBook extends Response {
    private List<Ask> ask;
    private List<Bid> bid;
    private long timestamp;
    private String currency;

    public List<Ask> getAsk() {
        return ask;
    }

    public void setAsk(List<Ask> ask) {
        this.ask = ask;
    }

    public List<Bid> getBid() {
        return bid;
    }

    public void setBid(List<Bid> bid) {
        this.bid = bid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "result='" + getResult() + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMsg='" + getErrorMsg() + '\'' +
                ", ask=" + ask +
                ", bid=" + bid +
                ", timestamp=" + timestamp +
                ", currency='" + currency + '\'' +
                '}';
    }
}
