package edu.goit.telegrambot;

import edu.goit.telegrambot.constant.BotConfig;
import edu.goit.telegrambot.constant.Constants;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class CurrencyBot extends AbilityBot {

    protected CurrencyBot() {
        this(BotConfig.BOT_TOKEN, BotConfig.BOT_USERNAME);
    }

    protected CurrencyBot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    @Override
    public long creatorId() {
        return BotConfig.CREATOR_ID;
    }

    public Ability commandStart() {
        return Ability
                .builder()
                .name("start")
                .info("start greeting")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send(Constants.START_GREETING, ctx.chatId()))
                .build();
    }




}
