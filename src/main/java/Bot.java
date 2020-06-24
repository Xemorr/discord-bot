import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Bot {

    GatewayIntent[] gatewayIntents = new GatewayIntent[]{};
    ListenerAdapter[] listenerAdapters = new ListenerAdapter[]{new Avatar(), new WelcomeMessage(), new PingPong(), new Invite(), new RoleReactions()};
    String token;
    JDA jda;

    public Bot(String token) {
        this.token = token;
    }

    public void build() {
        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS, gatewayIntents);
        jdaBuilder.addEventListeners(listenerAdapters);
        jdaBuilder.setActivity(Activity.watching("Xemor's Tutorial Series"));
        try {
            jda = jdaBuilder.build();
            jda.awaitReady();
            botInitialized();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void botInitialized() {
        Thread thread = new Thread(() -> {
            TextChannel textChannel = jda.getTextChannelById(679434326886318108L);
            while(true) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                if (message != null && message != "" && message != "\n") {
                    textChannel.sendMessage(message).queue();
                }
            }
        });
        thread.start();
    }

}
