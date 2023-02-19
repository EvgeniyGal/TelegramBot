package edu.goit.telegrambot.bank;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.goit.telegrambot.currency.Currency;
import edu.goit.telegrambot.currency.CurrencyType;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    static class NbuItem {
        private float rate;
        private CurrencyType cc;

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        public CurrencyType getCc() {
            return cc;
        }

        public void setCc(CurrencyType cc) {
            this.cc = cc;
        }
    }


    @Override
    public void updateRate() {
        for (Currency cur: currencies) {
            cur.setBuyRate(updateCurrencyRate(cur.getType()));
            cur.setSellRate(updateCurrencyRate(cur.getType()));
        }
    }


    public BigDecimal updateCurrencyRate(CurrencyType type) {
        String api = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        Gson gson = new Gson();
        String responce = "";
        try {
            responce = Jsoup
                    .connect(api)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<NbuItem> responseDtos = gson.fromJson(responce, new TypeToken<List<NbuItem>>() {
        }.getType());


        float result = responseDtos.stream()
                .filter(item ->item.getCc()!=null)
                .filter(item -> (item.getCc().equals(type)))
                .map(item -> item.getRate())
                .findFirst()
                .orElseThrow();
        return new BigDecimal(result);

    }
}




