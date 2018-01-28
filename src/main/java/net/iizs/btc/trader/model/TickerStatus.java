package net.iizs.btc.trader.model;

public class TickerStatus {
    private long lastUpdateTimestamp;
    private String exchangeName;
    private String currency;
    private int size;

    public long getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(long lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "TickerStatus{" +
                "lastUpdateTimestamp=" + lastUpdateTimestamp +
                ", exchangeName='" + exchangeName + '\'' +
                ", currency='" + currency + '\'' +
                ", size=" + size +
                '}';
    }
}
