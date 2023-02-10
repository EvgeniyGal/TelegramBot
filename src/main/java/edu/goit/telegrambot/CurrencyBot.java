package edu.goit.telegrambot;

import edu.goit.telegrambot.constants.BotConfig;
import edu.goit.telegrambot.responsehandler.ResponseHandler;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.bot.BaseAbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;
import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;

public class CurrencyBot extends AbilityBot {

    private final ResponseHandler responseHandler;

    public CurrencyBot() {

        this(BotConfig.BOT_TOKEN, BotConfig.BOT_USERNAME);
    }

    public CurrencyBot(String botToken, String botUsername) {

        super(botToken, botUsername);
        responseHandler = new ResponseHandler(sender, db);
    }

    @Override
    public long creatorId() {
        return BotConfig.CREATOR_ID;
    }

    public Ability replyToStart() {
        return Ability
                .builder()
                .name("start")
                .info("start greeting")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> responseHandler.replyToStart(ctx.chatId()))
                .build();
    }

    public Reply replyToButtons() {
        BiConsumer<BaseAbilityBot, Update> action = (bab, upd) -> responseHandler.replyToButtons(getChatId(upd), upd.getCallbackQuery().getData());
        return Reply.of(action, Flag.CALLBACK_QUERY);
    }


}
