package edu.goit.telegrambot.BankCurrencyRateService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class NbuCurrencyRateService implements CurrencyRateService{
    String api = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    Gson gson = new Gson();


    @Override
    public List<CurrencyRateDto> getCurrencyRateDto() throws IOException {
        String responce = Jsoup
                .connect(api)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        List<NbuCurrencyItemDto> responseDtos = convertToObject(responce);
        return convertToCurrencyRateDto(responseDtos);}



    private List<NbuCurrencyItemDto> convertToObject (String str) {
            Type type = TypeToken
                        .getParameterized(List.class, NbuCurrencyItemDto.class)
                        .getType();

            List <NbuCurrencyItemDto> responseDtos = gson.fromJson(str, type);
            return responseDtos;
    }


    private List<CurrencyRateDto> convertToCurrencyRateDto (List<NbuCurrencyItemDto> list) {
                return list.stream()
                            .filter(item -> (item.getCc()!=null))
                            .map (item -> {
                                            CurrencyRateDto currencyRateDto = new CurrencyRateDto();
                                            currencyRateDto.setCurrencyFrom(item.getCc());
                                            currencyRateDto.setCurrencyTo(CurrencyType.UAH);
                                            currencyRateDto.setBuy(item.getRate());
                                            currencyRateDto.setSell(item.getRate());
                                            currencyRateDto.setBank("НБУ");
                                            return currencyRateDto;
                                            })
                            .collect(Collectors.toList());}

    }

