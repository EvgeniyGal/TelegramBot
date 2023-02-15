package edu.goit.telegrambot.BankCurrencyRateService;

public class CurrencyRateDto {
    private CurrencyType currencyFrom;
    private CurrencyType currencyTo;
    private float buy;
    private float sell;
    private String bank;

    public CurrencyType getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(CurrencyType currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public CurrencyType getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(CurrencyType currencyTo) {
        this.currencyTo = currencyTo;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "CurrencyRateDto{" +
                "currencyFrom=" + currencyFrom +
                ", currencyTo=" + currencyTo +
                ", buy=" + buy +
                ", sell=" + sell +
                ", bank='" + bank + '\'' +
                '}';
    }


}