package edu.goit.telegrambot;

import edu.goit.telegrambot.cbuser.CBUser;
import edu.goit.telegrambot.currencubot.CurrencyBot;
import edu.goit.telegrambot.service.AutoSender;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AppLauncher {

    public static final Map<Long, CBUser> cbUsers = new ConcurrentHashMap<>();

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        AutoSender.startAutoSender();

        try {
            CurrencyBot bot = new CurrencyBot();
            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}