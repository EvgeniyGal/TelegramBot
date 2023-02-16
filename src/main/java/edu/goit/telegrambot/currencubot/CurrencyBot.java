package edu.goit.telegrambot.currencubot;

import edu.goit.telegrambot.constants.BotConfig;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.bot.BaseAbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Flag;
import org.telegram.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.function.BiConsumer;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;
import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;
import static org.telegram.abilitybots.api.util.AbilityUtils.getUser;

public class CurrencyBot extends AbilityBot {

    private static ResponseHandler responseHandler;

    public CurrencyBot() {

        this(BotConfig.BOT_TOKEN, BotConfig.BOT_USERNAME);
    }

    public CurrencyBot(String botToken, String botUsername) {

        super(botToken, botUsername);
        responseHandler = new ResponseHandler(sender);
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
        BiConsumer<BaseAbilityBot, Update> action = (bab, upd) -> responseHandler.replyToButtons(getUser(upd),
                getChatId(upd), upd.getCallbackQuery().getData());
        return Reply.of(action, Flag.CALLBACK_QUERY);
    }

    public static ResponseHandler getResponseHandler() {
        return responseHandler;
    }
}
