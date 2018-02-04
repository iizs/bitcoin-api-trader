package net.iizs.btc.trader.model;

import java.util.List;

public class TickerResponse extends ApiResponse {
    private List<Ticker> tickers;

    public List<Ticker> getTickers() {
        return tickers;
    }

    public void setTickers(List<Ticker> tickers) {
        this.tickers = tickers;
    }

    @Override
    public String toString() {
        return "TickerResponse{" +
                "tickers=" + tickers +
                ", status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
