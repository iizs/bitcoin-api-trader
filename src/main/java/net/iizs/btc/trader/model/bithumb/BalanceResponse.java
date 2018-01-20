package net.iizs.btc.trader.model.bithumb;

public class BalanceResponse extends Response {
    private BalanceData data;

    public BalanceData getData() {
        return data;
    }

    public void setData(BalanceData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
