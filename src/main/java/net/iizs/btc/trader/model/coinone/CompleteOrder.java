package net.iizs.btc.trader.model.coinone;

public class CompleteOrder {
    private long price;
    private double qty;
    private long timestamp;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CompleteOrder{" +
                "price=" + price +
                ", qty=" + qty +
                ", timestamp=" + timestamp +
                '}';
    }
}
