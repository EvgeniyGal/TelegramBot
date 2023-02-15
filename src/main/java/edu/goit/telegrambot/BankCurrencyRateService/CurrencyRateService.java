package edu.goit.telegrambot.BankCurrencyRateService;

import java.io.IOException;
import java.util.List;

public interface CurrencyRateService {
    public List<CurrencyRateDto> getCurrencyRateDto() throws IOException ;
}