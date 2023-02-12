package edu.goit.telegrambot.bank.monobank;

import edu.goit.telegrambot.bank.Bank;
import edu.goit.telegrambot.currency.CurrencyType;

import java.math.BigDecimal;

public class MonoBank extends Bank {

    private static final MonoBank monoBank = new MonoBank();

    private MonoBank(){}

    public static Bank getInstance(){
        return monoBank;
    }

    @Override
    public BigDecimal updateSellRate(CurrencyType currencyType) {
        return null;
    }

    @Override
    public BigDecimal updateBuyRate(CurrencyType currencyType) {
        return null;
    }
}
