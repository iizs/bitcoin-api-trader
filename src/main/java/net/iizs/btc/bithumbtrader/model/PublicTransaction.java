package net.iizs.btc.bithumbtrader.model;

public class PublicTransaction {
    private String transactionDate;
    private String type;
    private String unitsTraded;
    private String price;
    private String total;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitsTraded() {
        return unitsTraded;
    }

    public void setUnitsTraded(String unitsTraded) {
        this.unitsTraded = unitsTraded;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PublicTransaction{" +
                "transactionDate='" + transactionDate + '\'' +
                ", type='" + type + '\'' +
                ", unitsTraded='" + unitsTraded + '\'' +
                ", price='" + price + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
