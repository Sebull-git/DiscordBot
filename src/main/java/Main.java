
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("Nzc4MDI1MDk0NTI5MTU1MTMy.X7L-VQ.hmz6LNB4Qausfd94IYC5NGXec50");
        builder.addEventListeners(new Main());
        builder.build();


    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //Wenn Bot eine Nachricht Privat geschrieben wird
        if (event.getMessage().getContentRaw().equals("lol")) {
            event.getMessage().getChannel().sendMessage("lol zurück ").queue();
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getMessage().getChannel().sendMessage("pong!").queue();
        }
       if (event.getMessage().getContentRaw().equals("!stundenplan")){
             GregorianCalendar datenow = new GregorianCalendar();
             int day = datenow.get(GregorianCalendar.DAY_OF_WEEK);
             if (day == GregorianCalendar.MONDAY){
                 System.out.println("Montag");
                 event.getMessage().getChannel().sendMessage("1. bis 2. Stunde Fachbereich ").queue();
                 event.getMessage().getChannel().sendMessage("3. bis 4. Deutsch in 1401").queue();
                 event.getMessage().getChannel().sendMessage("5. bis 6. Chemie in 0308").queue();
                 event.getMessage().getChannel().sendMessage("7. bis 8. Fachbereich").queue();
             }
             else if(day == GregorianCalendar.TUESDAY){
                 System.out.println("Dienstag");
                 event.getMessage().getChannel().sendMessage("1.  bis 2. Englisch in 1201 ").queue();
                 event.getMessage().getChannel().sendMessage("3.  bis 4. Fachbereich").queue();
                 event.getMessage().getChannel().sendMessage("5. bis 6. Spanisch in 1104").queue();
                 event.getMessage().getChannel().sendMessage("7. bis 8. Geschichte in 1106").queue();

             }
             else if(day == GregorianCalendar.WEDNESDAY){
                 System.out.println("Mitwoch");
                 event.getMessage().getChannel().sendMessage("1.  bis 2. Stunde Spanisch in 1104 ").queue();
                 event.getMessage().getChannel().sendMessage("3.  bis 4. Deutsch in 1401").queue();
                 event.getMessage().getChannel().sendMessage("5. bis 6. Mathe in 1302").queue();
                 event.getMessage().getChannel().sendMessage("7. bis 8. Sport in SPH1").queue();
             }
             else if(day == GregorianCalendar.THURSDAY){
                 System.out.println("Donnerstag");
                 event.getMessage().getChannel().sendMessage("1.  bis 2. Fachbereich").queue();
                 event.getMessage().getChannel().sendMessage("3.  bis 4. Fachbereich").queue();
                 event.getMessage().getChannel().sendMessage("5. bis 6. Englisch in 1201").queue();
                 event.getMessage().getChannel().sendMessage("7. bis 8. Physik in 0303").queue();
             }
             else if(day == GregorianCalendar.FRIDAY){
                 System.out.println("Freitag");
                 event.getMessage().getChannel().sendMessage("1.  bis 2. Stunde Religion").queue();
                 event.getMessage().getChannel().sendMessage("3.  bis 4. Mathe in 1302").queue();
                 event.getMessage().getChannel().sendMessage("5. bis 6. POWI in 1401").queue();
             }
             else{
                 event.getMessage().getChannel().sendMessage("Ich schick dir mal den ganzen Stundenplan");
                 event.getMessage().getChannel().sendFile(new File("Datein/stundenijsw.PNG")).queue();
             }
       }
       else if (event.getMessage().getContentRaw().equals("!stundenplan_ganz")){
           event.getMessage().getChannel().sendMessage("Kriegst du").queue();
           event.getMessage().getChannel().sendFile(new File("Datein/stundenijsw.PNG")).queue();
       }
    }
}

