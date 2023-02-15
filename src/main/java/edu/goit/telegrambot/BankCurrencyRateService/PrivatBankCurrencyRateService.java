package edu.goit.telegrambot.BankCurrencyRateService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class PrivatBankCurrencyRateService implements CurrencyRateService {
    String api = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    Gson gson = new Gson();
    @Override
    public List<CurrencyRateDto> getCurrencyRateDto() throws IOException {
        String responce = Jsoup
                .connect(api)
                .ignoreContentType(true)
                .get()
                .body()
                .text();


        List<PrivatBankCurrencyItemDto> responseDtos = convertToObjects(responce);

        return convertToCurrencyRateDto(responseDtos);
    }


            private List<PrivatBankCurrencyItemDto> convertToObjects(String str) {
                    Type type = TypeToken
                            .getParameterized(List.class, PrivatBankCurrencyItemDto.class)
                            .getType();

                    List <PrivatBankCurrencyItemDto> responseDtos = gson.fromJson(str, type);
                    return responseDtos;
                    }


             private List<CurrencyRateDto> convertToCurrencyRateDto (List<PrivatBankCurrencyItemDto> list) {
                     return list.stream()
                             .map (item -> {
                                             CurrencyRateDto currencyRateDto = new CurrencyRateDto();
                                             currencyRateDto.setCurrencyFrom(item.getCcy());
                                             currencyRateDto.setCurrencyTo(item.getBase_ccy());
                                             currencyRateDto.setBuy(item.getBuy());
                                             currencyRateDto.setSell(item.getSale());
                                             currencyRateDto.setBank("Приватбанк");
                                             return currencyRateDto;
                                             })
                             .collect(Collectors.toList());
                             }

}
