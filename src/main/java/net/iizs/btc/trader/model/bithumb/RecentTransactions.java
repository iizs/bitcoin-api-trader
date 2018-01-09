package net.iizs.btc.trader.model.bithumb;

import java.util.List;

public class RecentTransactions {
    private String status;
    private List<PublicTransaction> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PublicTransaction> getData() {
        return data;
    }

    public void setData(List<PublicTransaction> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RecentTransactions{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
