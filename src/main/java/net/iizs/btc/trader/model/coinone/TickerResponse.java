package net.iizs.btc.trader.model.coinone;

import net.iizs.btc.trader.model.TickerInput;

// All values mean that of 24 hours
public class TickerResponse extends Response implements TickerInput{
    private long high;
    private long low;
    private long first;
    private long last;
    private double volume;
    private long yesterdayHigh;
    private long yesterdayLow;
    private long yesterdayFirst;
    private long yesterdayLast;
    private double yesterdayVolume;
    private long timestamp;
    private String currency;

    public long getHigh() {
        return high;
    }

    public void setHigh(long high) {
        this.high = high;
    }

    public long getLow() {
        return low;
    }

    public void setLow(long low) {
        this.low = low;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public long getLast() {
        return last;
    }

    // coinone uses term 'last' instead of 'current price'
    @Override
    public long getCurrentPrice() {
        return getLast();
    }

    public void setLast(long last) {
        this.last = last;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getExchangeName() {
        // @TODO hardcoded name
        return "coinone";
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getYesterdayHigh() {
        return yesterdayHigh;
    }

    public void setYesterdayHigh(long yesterdayHigh) {
        this.yesterdayHigh = yesterdayHigh;
    }

    public long getYesterdayLow() {
        return yesterdayLow;
    }

    public void setYesterdayLow(long yesterdayLow) {
        this.yesterdayLow = yesterdayLow;
    }

    public long getYesterdayFirst() {
        return yesterdayFirst;
    }

    public void setYesterdayFirst(long yesterdayFirst) {
        this.yesterdayFirst = yesterdayFirst;
    }

    public long getYesterdayLast() {
        return yesterdayLast;
    }

    public void setYesterdayLast(long yesterdayLast) {
        this.yesterdayLast = yesterdayLast;
    }

    public double getYesterdayVolume() {
        return yesterdayVolume;
    }

    public void setYesterdayVolume(double yesterdayVolume) {
        this.yesterdayVolume = yesterdayVolume;
    }

    // method to handle mal-formed json object. coinone has undocumented feature
    public void setYesterday_last(long yesterdayLast) {
        this.yesterdayLast = yesterdayLast;
    }

    // method to handle mal-formed json object. coinone has undocumented feature
    public void setYesterday_first(long yesterdayFirst) {
        this.yesterdayFirst = yesterdayFirst;
    }

    // method to handle mal-formed json object. coinone has undocumented feature
    public void setYesterday_low(long yesterdayLow) {
        this.yesterdayLow = yesterdayLow;
    }

    // method to handle mal-formed json object. coinone has undocumented feature
    public void setYesterday_high(long yesterdayHigh) {
        this.yesterdayHigh = yesterdayHigh;
    }

    // method to handle mal-formed json object. coinone has undocumented feature
    public void setYesterday_volume(double yesterdayVolume) {
        this.yesterdayVolume = yesterdayVolume;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "result='" + getResult() + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMsg='" + getErrorMsg() + '\'' +
                ", high=" + high +
                ", low=" + low +
                ", first=" + first +
                ", last=" + last +
                ", volume=" + volume +
                ", timestamp=" + timestamp +
                ", currency='" + currency + '\'' +
                '}';
    }
}
