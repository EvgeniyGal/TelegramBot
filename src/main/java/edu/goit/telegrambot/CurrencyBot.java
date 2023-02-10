package edu.goit.telegrambot;

import edu.goit.telegrambot.constant.BotConfig;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class CurrencyBot extends AbilityBot {

    protected CurrencyBot() {
        super(BotConfig.BOT_TOKEN, BotConfig.BOT_USERNAME);
    }

    protected CurrencyBot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    @Override
    public long creatorId() {
        return BotConfig.CREATOR_ID;
    }

    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world!")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("Hello world!", ctx.chatId()))
                .build();
    }

    public Ability command1() {
        return Ability
                .builder()
                .name("command1")
                .info("says hello world!")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("Hello from command1!!!!!", ctx.chatId()))
                .build();
    }

}
