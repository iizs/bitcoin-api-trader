package net.iizs.btc.trader.model.coinone;

import java.util.List;

public class RecentCompleteOrders extends Response {
    private List<CompleteOrder> completeOrders;
    private String currency;
    private long timestamp;

    public List<CompleteOrder> getCompleteOrders() {
        return completeOrders;
    }

    public void setCompleteOrders(List<CompleteOrder> completeOrders) {
        this.completeOrders = completeOrders;
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

    @Override
    public String toString() {
        return "RecentCompleteOrders{" +
                "result='" + getResult() + '\'' +
                ", errorCode=" + getErrorCode() +
                ", errorMsg='" + getErrorMsg() + '\'' +
                ", completeOrders=" + completeOrders +
                ", currency='" + currency + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
