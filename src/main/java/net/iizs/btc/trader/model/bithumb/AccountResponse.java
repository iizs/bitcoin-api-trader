package net.iizs.btc.trader.model.bithumb;

public class AccountResponse extends Response {
    private AccountData data;

    public AccountData getData() {
        return data;
    }

    public void setData(AccountData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Account{" +
                "data=" + data +
                ", status='" + status + '\'' +
                '}';
    }
}
