package net.iizs.btc.trader.model.bithumb;

public class Balance {
    private String status;
    private BalanceData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
