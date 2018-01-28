package net.iizs.btc.trader.model;

public class TickerStatusResponse extends ApiResponse{
    private TickerServiceStatus tickerServiceStatus;

    public TickerServiceStatus getTickerServiceStatus() {
        return tickerServiceStatus;
    }

    public void setTickerServiceStatus(TickerServiceStatus tickerStatus) {
        this.tickerServiceStatus = tickerStatus;
    }

    @Override
    public String toString() {
        return "TickerStatusResponse{" +
                "tickerServiceStatus=" + tickerServiceStatus +
                ", status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
