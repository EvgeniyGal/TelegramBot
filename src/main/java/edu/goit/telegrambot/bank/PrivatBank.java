package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PrivatBank extends Bank {
    private static final PrivatBank privatBank = new PrivatBank();

    private PrivatBank() {
        this.name = "Приватбанк";
        this.currencies = new ArrayList<>();
        currencies.add(new Currency(CurrencyType.USD, BigDecimal.ZERO, BigDecimal.ZERO));
        currencies.add(new Currency(CurrencyType.EUR, BigDecimal.ZERO, BigDecimal.ZERO));
    }

    public static Bank getInstance(){
        return privatBank;
    }


    @Override
    public void updateRate() {

    }
}
