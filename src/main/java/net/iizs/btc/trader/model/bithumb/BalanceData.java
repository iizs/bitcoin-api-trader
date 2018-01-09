package net.iizs.btc.trader.model.bithumb;

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

    private String totalBch;
    private String inUseBch;
    private String misuBch;
    private String availableBch;

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

    public String getTotalBch() {
        return totalBch;
    }

    public void setTotalBch(String totalBch) {
        this.totalBch = totalBch;
    }

    public String getInUseBch() {
        return inUseBch;
    }

    public void setInUseBch(String inUseBch) {
        this.inUseBch = inUseBch;
    }

    public String getMisuBch() {
        return misuBch;
    }

    public void setMisuBch(String misuBch) {
        this.misuBch = misuBch;
    }

    public String getAvailableBch() {
        return availableBch;
    }

    public void setAvailableBch(String availableBch) {
        this.availableBch = availableBch;
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
                ", totalBch='" + totalBch + '\'' +
                ", inUseBch='" + inUseBch + '\'' +
                ", misuBch='" + misuBch + '\'' +
                ", availableBch='" + availableBch + '\'' +
                '}';
    }
}
