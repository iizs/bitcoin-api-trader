package net.iizs.btc.trader.model;

public class TickerValue {
    private String exchangeName;
    private String currency;
    private long timestamp;
    private long currentPrice;
    private long movingAverage5CurrentPrice;
    private long movingAverage20CurrentPrice;
    private long movingAverage90CurrentPrice;
    private long movingAverage120CurrentPrice;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public long getMovingAverage5CurrentPrice() {
        return movingAverage5CurrentPrice;
    }

    public void setMovingAverage5CurrentPrice(long movingAverage5CurrentPrice) {
        this.movingAverage5CurrentPrice = movingAverage5CurrentPrice;
    }

    public long getMovingAverage20CurrentPrice() {
        return movingAverage20CurrentPrice;
    }

    public void setMovingAverage20CurrentPrice(long movingAverage20CurrentPrice) {
        this.movingAverage20CurrentPrice = movingAverage20CurrentPrice;
    }

    public long getMovingAverage90CurrentPrice() {
        return movingAverage90CurrentPrice;
    }

    public void setMovingAverage90CurrentPrice(long movingAverage90CurrentPrice) {
        this.movingAverage90CurrentPrice = movingAverage90CurrentPrice;
    }

    public long getMovingAverage120CurrentPrice() {
        return movingAverage120CurrentPrice;
    }

    public void setMovingAverage120CurrentPrice(long movingAverage120CurrentPrice) {
        this.movingAverage120CurrentPrice = movingAverage120CurrentPrice;
    }

    @Override
    public String toString() {
        return "TickerValue{" +
                "exchangeName='" + exchangeName + '\'' +
                ", currency='" + currency + '\'' +
                ", timestamp=" + timestamp +
                ", currentPrice=" + currentPrice +
                ", movingAverage5CurrentPrice=" + movingAverage5CurrentPrice +
                ", movingAverage20CurrentPrice=" + movingAverage20CurrentPrice +
                ", movingAverage90CurrentPrice=" + movingAverage90CurrentPrice +
                ", movingAverage120CurrentPrice=" + movingAverage120CurrentPrice +
                '}';
    }
}
