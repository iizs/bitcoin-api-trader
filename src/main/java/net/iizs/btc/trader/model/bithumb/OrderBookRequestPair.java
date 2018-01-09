package net.iizs.btc.trader.model.bithumb;

public class OrderBookRequestPair {
    private String quantity;
    private String price;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderBookRequestPair{" +
                "quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
