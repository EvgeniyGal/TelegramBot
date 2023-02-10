package edu.goit.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {

    public static void main(String[] args) throws TelegramApiException {

        // Create the TelegramBotsApi object to register your bots
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            // Register your newly created AbilityBot
            CurrencyBot bot = new CurrencyBot();
            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}