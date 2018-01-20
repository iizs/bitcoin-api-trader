package net.iizs.btc.trader.model.bithumb;

import java.util.List;

public class RecentTransactionsResponse extends Response{
    private List<PublicTransaction> data;

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
