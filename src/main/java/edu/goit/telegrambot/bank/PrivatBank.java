package edu.goit.telegrambot.bank;

import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

public class PrivatBank extends Bank {

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private static final PrivatBank privatBank = new PrivatBank();
    private String response;

    private PrivatBank() {
        this.name = "Приватбанк";
        this.currencies = new ArrayList<>();
        currencies.add(new Currency(CurrencyType.USD, BigDecimal.ZERO, BigDecimal.ZERO));
        currencies.add(new Currency(CurrencyType.EUR, BigDecimal.ZERO, BigDecimal.ZERO));
        updateRate();
    }

    public static Bank getInstance() {
        return privatBank;
    }

    @Data
    static class PrivatItem {
        private String ccy, base_ccy;
        private double buy, sale;
    }

    @Override
    public void updateRate() {
        response = respBody();
        for (Currency cur : currencies) {
            cur.setSellRate(updateSellRate(cur.getType()));
            cur.setBuyRate(updateBuyRate(cur.getType()));
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
            System.out.println(e.getMessage());
            return null;
        }
    }

    private BigDecimal updateBuyRate(CurrencyType currenType) {
        if (response == null) {
            return currencies.stream().map(Currency::getBuyRate).findFirst().orElseThrow();
        } else {
            List<PrivatItem> privatItemList = new Gson().fromJson(response, new TypeToken<List<PrivatItem>>() {
            }.getType());
            double result = privatItemList.stream()
                    .filter(item -> item.ccy.equals(currenType.name()))
                    .map(PrivatItem::getBuy)
                    .findFirst()
                    .orElseThrow();
            return new BigDecimal(result);
        }
    }

    private BigDecimal updateSellRate(CurrencyType currenType) {
        if (response == null) {
            return currencies.stream().map(Currency::getBuyRate).findFirst().orElseThrow();
        } else {
            List<PrivatItem> privatItemList = new Gson().fromJson(response, new TypeToken<List<PrivatBank.PrivatItem>>() {
            }.getType());
            double result = privatItemList.stream()
                    .filter(item -> item.ccy.equals(currenType.name()))
                    .map(PrivatItem::getSale)
                    .findFirst()
                    .orElseThrow();
            return new BigDecimal(result);
        }
    }
}
