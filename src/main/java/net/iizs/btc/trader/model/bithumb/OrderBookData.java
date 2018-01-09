package net.iizs.btc.trader.model.bithumb;

import java.util.List;

public class OrderBookData {
    private String timestamp;
    private String orderCurrency;
    private String paymentCurrency;
    private List<OrderBookRequestPair> bids;
    private List<OrderBookRequestPair> asks;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public List<OrderBookRequestPair> getBids() {
        return bids;
    }

    public void setBids(List<OrderBookRequestPair> bids) {
        this.bids = bids;
    }

    public List<OrderBookRequestPair> getAsks() {
        return asks;
    }

    public void setAsks(List<OrderBookRequestPair> asks) {
        this.asks = asks;
    }

    @Override
    public String toString() {
        return "OrderBookData{" +
                "timestamp='" + timestamp + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", paymentCurrency='" + paymentCurrency + '\'' +
                ", bids=" + bids +
                ", asks=" + asks +
                '}';
    }
}
