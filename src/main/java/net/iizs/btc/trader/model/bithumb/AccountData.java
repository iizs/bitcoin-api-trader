package net.iizs.btc.trader.model.bithumb;

public class AccountData {
    private String created;
    private String accountId;
    private String tradeFee;
    private String balance;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(String tradeFee) {
        this.tradeFee = tradeFee;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "created='" + created + '\'' +
                ", accountId='" + accountId + '\'' +
                ", tradeFee='" + tradeFee + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
