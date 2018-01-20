package net.iizs.btc.trader.model.bithumb;

public class TickerResponse extends Response {
    private TickerData data;

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
