package edu.goit.telegrambot.bank.nbu_bank;

import edu.goit.telegrambot.bank.Bank;
import edu.goit.telegrambot.currency.CurrencyType;

import java.math.BigDecimal;

public class NBUBank extends Bank {

    private static final NBUBank nbuBank = new NBUBank();

    private NBUBank(){}

    public static Bank getInstance(){
        return nbuBank;
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
