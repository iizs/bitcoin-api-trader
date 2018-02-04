package net.iizs.btc.trader.model;

import java.util.List;

public class Ticker {
    private String exchangeName;
    private String currency;
    private List<TickerValue> values;

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

    public List<TickerValue> getValues() {
        return values;
    }

    public void setValues(List<TickerValue> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "exchangeName='" + exchangeName + '\'' +
                ", currency='" + currency + '\'' +
                ", values=" + values +
                '}';
    }
}
