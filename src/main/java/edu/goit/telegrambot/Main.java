package edu.goit.telegrambot;

import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.currencubot.CurrencyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;


public class Main {

    public static final HashMap<Long, CBUser> cbUsers = new HashMap<>();

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