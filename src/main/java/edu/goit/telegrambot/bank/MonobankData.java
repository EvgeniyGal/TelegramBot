package banks;

import java.util.Objects;

public class MonobankData {
    private long date;
    private int currencyCodeA, currencyCodeB;
    private float rateSell,rateBuy,rateCross;

    public MonobankData(long date, int currencyCodeA, int currencyCodeB, float rateSell, float rateBuy, float rateCross) {
        this.date = date;
        this.currencyCodeA = currencyCodeA;
        this.currencyCodeB = currencyCodeB;
        this.rateSell = rateSell;
        this.rateBuy = rateBuy;
        this.rateCross = rateCross;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(int currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public int getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(int currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public float getRateSell() {
        return rateSell;
    }

    public void setRateSell(float rateSell) {
        this.rateSell = rateSell;
    }

    public float getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(float rateBuy) {
        this.rateBuy = rateBuy;
    }

    public float getRateCross() {
        return rateCross;
    }

    public void setRateCross(float rateCross) {
        this.rateCross = rateCross;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonobankData that = (MonobankData) o;
        return date == that.date && currencyCodeA == that.currencyCodeA && currencyCodeB == that.currencyCodeB && Float.compare(that.rateSell, rateSell) == 0 && Float.compare(that.rateBuy, rateBuy) == 0 && Float.compare(that.rateCross, rateCross) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, currencyCodeA, currencyCodeB, rateSell, rateBuy, rateCross);
    }
}
