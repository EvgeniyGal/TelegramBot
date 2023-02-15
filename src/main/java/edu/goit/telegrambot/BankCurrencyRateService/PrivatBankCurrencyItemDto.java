package edu.goit.telegrambot.BankCurrencyRateService;

public class PrivatBankCurrencyItemDto {
    private CurrencyType ccy;
    private CurrencyType base_ccy;
    private float buy;
    private float sale;

    public CurrencyType getCcy() {
        return ccy;
    }

    public void setCcy(CurrencyType ccy) {
        this.ccy = ccy;
    }

    public CurrencyType getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(CurrencyType base_ccy) {
        this.base_ccy = base_ccy;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "PrivatBankCurrencyItemDto{" +
                "ccy=" + ccy +
                ", base_ccy=" + base_ccy +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }


}
