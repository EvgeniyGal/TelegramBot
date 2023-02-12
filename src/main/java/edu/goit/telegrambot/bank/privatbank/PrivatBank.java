package edu.goit.telegrambot.bank.privatbank;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.goit.telegrambot.bank.Bank;
import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrivatBank extends Bank {
    static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private static final PrivatBank privatBank = new PrivatBank("ПриватБанк", new ArrayList<>());

    private PrivatBank(String name, List<Currency> currencies){
        this.name = name;
        this.currencies = currencies;
        currencies.add(new Currency(CurrencyType.USD, updateSellRate(CurrencyType.USD), updateBuyRate(CurrencyType.USD)));
        currencies.add(new Currency(CurrencyType.EUR, updateSellRate(CurrencyType.EUR), updateBuyRate(CurrencyType.EUR)));
    }

    public static Bank getInstance(){
        return privatBank;
    }


    @Override
    public BigDecimal updateSellRate(CurrencyType currencyType) {
        String json;
        try {
            json = Jsoup.connect(URL)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<CurrencyItemPB> items = new Gson().fromJson(json, new TypeToken<List<CurrencyItemPB>>(){}.getType());
        double result = items.stream()
                .filter(sell -> sell.getCcy().equals(currencyType.name()))
                .map(CurrencyItemPB::getSale)
                .findFirst()
                .orElseThrow();
        return BigDecimal.valueOf(result);
    }

    @Override
    public BigDecimal updateBuyRate(CurrencyType currencyType) {
        String json;
        try {
            json = Jsoup.connect(URL)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<CurrencyItemPB> items = new Gson().fromJson(json, new TypeToken<List<CurrencyItemPB>>(){}.getType());
        double result = items.stream()
                .filter(sell -> sell.getCcy().equals(currencyType.name()))
                .map(CurrencyItemPB::getBuy)
                .findFirst()
                .orElseThrow();
        return BigDecimal.valueOf(result);
    }
}
