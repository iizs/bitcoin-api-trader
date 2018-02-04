package net.iizs.btc.trader.model.bithumb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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
