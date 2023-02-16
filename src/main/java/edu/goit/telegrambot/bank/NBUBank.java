package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NBUBank extends Bank {

    private static final NBUBank nbuBank = new NBUBank();

    private NBUBank() {
        this.name = "НБУ";
        this.currencies = new ArrayList<>();
        currencies.add(new Currency(CurrencyType.USD, BigDecimal.ZERO, BigDecimal.ZERO));
        currencies.add(new Currency(CurrencyType.EUR, BigDecimal.ZERO, BigDecimal.ZERO));
    }

    public static Bank getInstance(){
        return nbuBank;
    }

    @Override
    void updateRate() {

    }
}
