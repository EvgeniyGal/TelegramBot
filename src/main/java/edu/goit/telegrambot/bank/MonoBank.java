package edu.goit.telegrambot.bank;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;
import lombok.Data;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonoBank extends Bank {

    private static final String URL = "https://api.monobank.ua/bank/currency";
    private static final MonoBank monoBank = new MonoBank("МоноБанк", new ArrayList<>());

    private MonoBank(String name, List<Currency> currencies) {
        this.name = name;
        this.currencies = currencies;
        currencies.add(new Currency(CurrencyType.USD, BigDecimal.ZERO, BigDecimal.ZERO));
        currencies.add(new Currency(CurrencyType.EUR, BigDecimal.ZERO, BigDecimal.ZERO));
    }

    public static Bank getInstance() {
        return monoBank;
    }

    @Data
    static class MonoItem {
        private int currencyCodeA, currencyCodeB;
        private double rateBuy, rateSell;
    }

    @Override
    void updateRate() {
        for (Currency cur : currencies) {
            cur.setBuyRate(updateBuyRate(cur.getType()));
            cur.setSellRate(updateSellRate(cur.getType()));
        }
    }

    String respBody() {
        try {
            return Jsoup.connect(URL)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BigDecimal updateBuyRate(CurrencyType currenType) {
        List<MonoItem> monoItems = new Gson().fromJson(respBody(), new TypeToken<List<MonoItem>>() {
        }.getType());
        double result = monoItems.stream()
                .filter(item -> item.getCurrencyCodeA() == java.util.Currency.getInstance(currenType.name()).getNumericCode())
                .map(MonoItem::getRateBuy)
                .findFirst()
                .orElseThrow();
        return new BigDecimal(result);
    }

    BigDecimal updateSellRate(CurrencyType currenType) {
        List<MonoItem> monoItems = new Gson().fromJson(respBody(), new TypeToken<List<MonoItem>>() {
        }.getType());
        double result = monoItems.stream()
                .filter(item -> item.getCurrencyCodeA() == java.util.Currency.getInstance(currenType.name()).getNumericCode())
                .map(MonoItem::getRateSell)
                .findFirst()
                .orElseThrow();
        return new BigDecimal(result);
    }
}