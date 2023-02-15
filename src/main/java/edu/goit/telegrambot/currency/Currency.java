package edu.goit.telegrambot.currency;

import java.math.BigDecimal;

public class Currency {
    CurrencyType type;
    BigDecimal sellRate;
    BigDecimal buyRate;

    public Currency(CurrencyType type, BigDecimal sellRate, BigDecimal buyRate) {
        this.type = type;
        this.sellRate = sellRate;
        this.buyRate = buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public CurrencyType getType() {
        return type;
    }
}
