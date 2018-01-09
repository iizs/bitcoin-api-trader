package net.iizs.btc.trader.model.coinone;

public class Bid {
    private long price;
    private double qty;

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

    @Override
    public String toString() {
        return "Ask{" +
                "price=" + price +
                ", qty=" + qty +
                '}';
    }
}
