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
    private static final MonoBank monoBank = new MonoBank();
    private String response;

    private MonoBank() {
        this.name = "МоноБанк";
        this.currencies = new ArrayList<>();
        currencies.add(new Currency(CurrencyType.USD, BigDecimal.ZERO, BigDecimal.ZERO));
        currencies.add(new Currency(CurrencyType.EUR, BigDecimal.ZERO, BigDecimal.ZERO));
        updateRate();
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
    public void updateRate() {
        response = respBody();
        for (Currency cur : currencies) {
            cur.setBuyRate(updateBuyRate(cur.getType()));
            cur.setSellRate(updateSellRate(cur.getType()));
        }
    }

    private String respBody() {
        try {
            return Jsoup.connect(URL)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            return "Too many requests";
        }
    }

    private BigDecimal updateBuyRate(CurrencyType currenType) {
        if (response.equals("Too many requests")) {
            return currencies.stream().map(Currency::getBuyRate).findFirst().orElseThrow();
        } else {
            List<MonoItem> monoItems = new Gson().fromJson(response, new TypeToken<List<MonoItem>>() {
            }.getType());
            double result = monoItems.stream()
                    .filter(item -> item.getCurrencyCodeA() == java.util.Currency.getInstance(currenType.name()).getNumericCode())
                    .filter(item -> item.getCurrencyCodeB() == java.util.Currency.getInstance(CurrencyType.UAH.name()).getNumericCode())
                    .map(MonoItem::getRateBuy)
                    .findFirst()
                    .orElseThrow();
            return new BigDecimal(result);
        }
    }

    private BigDecimal updateSellRate(CurrencyType currenType) {
        if (response.equals("Too many requests")) {
            return currencies.stream().map(Currency::getSellRate).findFirst().orElseThrow();
        } else {
            List<MonoItem> monoItems = new Gson().fromJson(response, new TypeToken<List<MonoItem>>() {
            }.getType());
            double result = monoItems.stream()
                    .filter(item -> item.getCurrencyCodeA() == java.util.Currency.getInstance(currenType.name()).getNumericCode())
                    .filter(item -> item.getCurrencyCodeB() == java.util.Currency.getInstance(CurrencyType.UAH.name()).getNumericCode())
                    .map(MonoItem::getRateSell)
                    .findFirst()
                    .orElseThrow();
            return new BigDecimal(result);
        }
    }
}