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

public class NBUBank extends Bank {

    private static final NBUBank nbuBank = new NBUBank();

    private NBUBank() {
        this.name = "НБУ";
        this.currencies = new ArrayList<>();
        currencies.add(new Currency(CurrencyType.USD, BigDecimal.ZERO, BigDecimal.ZERO));
        currencies.add(new Currency(CurrencyType.EUR, BigDecimal.ZERO, BigDecimal.ZERO));
        updateRate();
    }

    public static Bank getInstance() {
        return nbuBank;
    }

    @Data
    static class NbuItem {
        private float rate;
        private CurrencyType cc;
    }


    @Override
    public void updateRate() {
        for (Currency cur : currencies) {
            cur.setBuyRate(updateCurrencyRate(cur.getType(), "buy"));
            cur.setSellRate(updateCurrencyRate(cur.getType(), "sell"));
        }
    }


    public BigDecimal updateCurrencyRate(CurrencyType type, String operation) {
        String api = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        Gson gson = new Gson();
        String responce;
        try {
            responce = Jsoup
                    .connect(api)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();

        } catch (IOException e) {
            if (operation.equals("buy")) {
                return currencies.stream().map(Currency::getBuyRate).findFirst().orElseThrow();
            } else {
                return currencies.stream().map(Currency::getSellRate).findFirst().orElseThrow();
            }
        }

        List<NbuItem> responseDtos = gson.fromJson(responce, new TypeToken<List<NbuItem>>() {
        }.getType());

        float result = responseDtos.stream()
                .filter(item -> item.getCc() != null)
                .filter(item -> (item.getCc().equals(type)))
                .map(NbuItem::getRate)
                .findFirst()
                .orElseThrow();
        return new BigDecimal(result);

    }
}




