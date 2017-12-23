package net.iizs.btc.bithumbtrader.model;

public class Ticker {
    private String status;
    private TickerData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TickerData getData() {
        return data;
    }

    public void setData(TickerData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
