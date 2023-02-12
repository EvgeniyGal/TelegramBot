package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class Bank {

    public String name;
    public List<Currency> currencies;

    public abstract BigDecimal updateSellRate(CurrencyType currencyType);

    public abstract BigDecimal updateBuyRate(CurrencyType currencyType);

    public String getCurrencyRate(CurrencyType curType, int tolerance) {
        String rate = String.format("Курс в %s: %s/%s\n", name, curType, CurrencyType.UAH.name()) +
                "Купівля: " + new BigDecimal(String.valueOf(updateBuyRate(curType).setScale(tolerance, RoundingMode.HALF_UP))) +
                "\nПродаж: " + new BigDecimal(String.valueOf(updateSellRate(curType).setScale(tolerance, RoundingMode.HALF_UP)));
        System.out.println(rate);
        return rate;
    }
}
