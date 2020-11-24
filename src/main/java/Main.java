
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken("Nzc4MDI1MDk0NTI5MTU1MTMy.X7L-VQ.pM7OywrsHQ7WV_PZ1HnrQBLC8AA");
        builder.addEventListeners(new Main());
        builder.build();


    }

    public void onMessageReceived(MessageReceivedEvent event) {
        //Wenn Bot eine Nachricht Privat geschrieben wird
        if (event.getMessage().getContentRaw().equals("lol")) {
            event.getChannel().sendMessage("lol zurück ").queue();
        } else if (event.isFromGuild()) {
            if (event.getMessage().getContentRaw().equals("!ping")) {
                event.getChannel().sendMessage("Pong!").queue();
            }
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        System.out.println("Message");
        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("pong!").queue();
        }
    }
}

