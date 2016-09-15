package ua.org.fits.rate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ua.org.fits.enums.Currency;
import ua.org.fits.serialize.*;

import java.time.LocalDateTime;


public class InterBank {

    private long id;
//    @JsonSerialize(using = LocalDateTimeStringConverter.class)

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime pointDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("date")
    private LocalDateTime pDate;

    private Double bid;
    private Double ask;
    private Double trendAsk;
    private Double trendBid;

    @JsonSerialize(using = CurrencySerializer.class)
    @JsonDeserialize(using = CurrencyDeserializer.class)
    private Currency currency;

    @JsonProperty("status")
    @JsonDeserialize(using = StatusDeserializer.class)
    private String isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getPointDate() {
        return pointDate;
    }

    public void setPointDate(LocalDateTime pointDate) {
        this.pointDate = pointDate;
    }

    public LocalDateTime getpDate() {
        return pDate;
    }

    public void setpDate(LocalDateTime pDate) {
        this.pDate = pDate;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getTrendAsk() {
        return trendAsk;
    }

    public void setTrendAsk(Double trendAsk) {
        this.trendAsk = trendAsk;
    }

    public Double getTrendBid() {
        return trendBid;
    }

    public void setTrendBid(Double trendBid) {
        this.trendBid = trendBid;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InterBank)) return false;

        InterBank interBank = (InterBank) o;

        if (id != interBank.id) return false;
        if (!pointDate.equals(interBank.pointDate)) return false;
        if (!pDate.equals(interBank.pDate)) return false;
        if (!bid.equals(interBank.bid)) return false;
        if (!ask.equals(interBank.ask)) return false;
        if (trendAsk != null ? !trendAsk.equals(interBank.trendAsk) : interBank.trendAsk != null) return false;
        if (trendBid != null ? !trendBid.equals(interBank.trendBid) : interBank.trendBid != null) return false;
        if (!currency.equals(interBank.currency)) return false;
        return isDeleted != null ? isDeleted.equals(interBank.isDeleted) : interBank.isDeleted == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + pointDate.hashCode();
        result = 31 * result + pDate.hashCode();
        result = 31 * result + bid.hashCode();
        result = 31 * result + ask.hashCode();
        result = 31 * result + (trendAsk != null ? trendAsk.hashCode() : 0);
        result = 31 * result + (trendBid != null ? trendBid.hashCode() : 0);
        result = 31 * result + currency.hashCode();
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InterBank{" +
                "id=" + id +
                ", pointDate=" + pointDate +
                ", pDate=" + pDate +
                ", bid=" + bid +
                ", ask=" + ask +
                ", trendAsk=" + trendAsk +
                ", trendBid=" + trendBid +
                ", currency=" + currency +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
