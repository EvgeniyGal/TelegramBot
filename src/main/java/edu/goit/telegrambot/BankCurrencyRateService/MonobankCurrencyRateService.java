package edu.goit.telegrambot.BankCurrencyRateService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MonobankCurrencyRateService implements CurrencyRateService {
    String api = "https://api.monobank.ua/bank/currency";
    Gson gson = new Gson();

    @Override
    public List<CurrencyRateDto> getCurrencyRateDto() throws IOException {
        String responce = Jsoup
                .connect(api)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        List<MonobankCurrencyItemDto> responseDtos = convertToObject(responce);

        return convertToCurrencyRateDto(responseDtos);

    }
        private List<MonobankCurrencyItemDto> convertToObject (String str) {
                Type type = TypeToken
                    .getParameterized(List.class, MonobankCurrencyItemDto.class)
                    .getType();
                List<MonobankCurrencyItemDto> responseDtos = gson.fromJson(str, type);
                return  responseDtos;}


        private List<CurrencyRateDto> convertToCurrencyRateDto (List < MonobankCurrencyItemDto > list) {
            Map<Integer, CurrencyType> mapa = Map.of(
                    840, CurrencyType.USD,
                    978, CurrencyType.EUR,
                    980, CurrencyType.UAH
                    );

                return list.stream()
                            .filter(item ->
                                    ((item.getCurrencyCodeA() == 840 || item.getCurrencyCodeA() == 978) && item.getCurrencyCodeB() == 980))

                            .map(item -> {
                                    CurrencyRateDto currencyRateDto = new CurrencyRateDto();
                                     if (mapa.containsKey(item.getCurrencyCodeA())) {
                                        currencyRateDto.setCurrencyFrom(mapa.get(item.getCurrencyCodeA()));
                                     };
                                     if (mapa.containsKey(item.getCurrencyCodeB())) {
                                        currencyRateDto.setCurrencyTo(mapa.get(item.getCurrencyCodeB()));
                                     }
                                     currencyRateDto.setBuy(item.getRateBuy());
                                     currencyRateDto.setSell(item.getRateSell());
                                     currencyRateDto.setBank("Монобанк");
                                     return currencyRateDto;
                            })
                            .collect(Collectors.toList());
            }
    }

