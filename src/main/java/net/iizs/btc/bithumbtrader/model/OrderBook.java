package net.iizs.btc.bithumbtrader.model;

public class OrderBook {
    private String status;
    private OrderBookData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderBookData getData() {
        return data;
    }

    public void setData(OrderBookData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
