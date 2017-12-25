package net.iizs.btc.bithumbtrader.model;

public class BalanceData {
    private String totalBtc;
    private String totalKrw;
    private String inUseBtc;
    private String inUseKrw;
    private String misuBtc;
    private String misuKrw;
    private String availableBtc;
    private String availableKrw;
    private String xcoinLast;

    public String getTotalBtc() {
        return totalBtc;
    }

    public void setTotalBtc(String totalBtc) {
        this.totalBtc = totalBtc;
    }

    public String getTotalKrw() {
        return totalKrw;
    }

    public void setTotalKrw(String totalKrw) {
        this.totalKrw = totalKrw;
    }

    public String getInUseBtc() {
        return inUseBtc;
    }

    public void setInUseBtc(String inUseBtc) {
        this.inUseBtc = inUseBtc;
    }

    public String getInUseKrw() {
        return inUseKrw;
    }

    public void setInUseKrw(String inUseKrw) {
        this.inUseKrw = inUseKrw;
    }

    public String getAvailableBtc() {
        return availableBtc;
    }

    public void setAvailableBtc(String availableBtc) {
        this.availableBtc = availableBtc;
    }

    public String getAvailableKrw() {
        return availableKrw;
    }

    public void setAvailableKrw(String availableKrw) {
        this.availableKrw = availableKrw;
    }

    public String getXcoinLast() {
        return xcoinLast;
    }

    public void setXcoinLast(String xcoinLast) {
        this.xcoinLast = xcoinLast;
    }

    public String getMisuKrw() {
        return misuKrw;
    }

    public void setMisuKrw(String misuKrw) {
        this.misuKrw = misuKrw;
    }

    public String getMisuBtc() {
        return misuBtc;
    }

    public void setMisuBtc(String misuBtc) {
        this.misuBtc = misuBtc;
    }

    @Override
    public String toString() {
        return "BalanceData{" +
                "totalBtc='" + totalBtc + '\'' +
                ", totalKrw='" + totalKrw + '\'' +
                ", inUseBtc='" + inUseBtc + '\'' +
                ", inUseKrw='" + inUseKrw + '\'' +
                ", misuBtc='" + misuBtc + '\'' +
                ", misuKrw='" + misuKrw + '\'' +
                ", availableBtc='" + availableBtc + '\'' +
                ", availableKrw='" + availableKrw + '\'' +
                ", xcoinLast='" + xcoinLast + '\'' +
                '}';
    }
}
