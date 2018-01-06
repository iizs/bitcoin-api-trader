package net.iizs.btc.bithumbtrader.model;

public class Account {
    private String status;
    private AccountData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AccountData getData() {
        return data;
    }

    public void setData(AccountData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Account{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
