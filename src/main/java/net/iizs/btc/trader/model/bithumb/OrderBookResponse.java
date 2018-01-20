package net.iizs.btc.trader.model.bithumb;

public class OrderBookResponse extends Response {
    private OrderBookData data;

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
