package net.iizs.btc.trader.model;

public interface TickerInput {
    public String getExchangeName();
    public String getCurrency();
    public long getTimestamp();
    public long getCurrentPrice();
}
