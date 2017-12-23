package net.iizs.btc.bithumbtrader.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerData {
    private String openingPrice;
    private String closingPrice;
    private String minPrice;
    private String maxPrice;
    private String averagePrice;
    private String unitsTraded;
    private String volume_1day;
    private String volume_7day;
    private String buyPrice;
    private String sellPrice;
    private long date;

    public String getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(String openingPrice) {
        this.openingPrice = openingPrice;
    }

    public String getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(String closingPrice) {
        this.closingPrice = closingPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getUnitsTraded() {
        return unitsTraded;
    }

    public void setUnitsTraded(String unitsTraded) {
        this.unitsTraded = unitsTraded;
    }

    public String getVolume_1day() {
        return volume_1day;
    }

    public void setVolume_1day(String volume_1day) {
        this.volume_1day = volume_1day;
    }

    public String getVolume_7day() {
        return volume_7day;
    }

    public void setVolume_7day(String volume_7day) {
        this.volume_7day = volume_7day;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

}
