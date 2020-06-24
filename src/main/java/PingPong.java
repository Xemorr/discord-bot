
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class PingPong extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equals("!ping")) {
            e.getChannel().sendMessage(createEmbed()).queue();
        }
    }

    public MessageEmbed createEmbed() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("!ping");
        embedBuilder.addField("Isn't Pong an epic word?", "pong!", true);
        embedBuilder.setThumbnail("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2F2.bp.blogspot.com%2F-wfzwKB-IfZY%2FUQ1nRoD0rLI%2FAAAAAAAAoVM%2FzuevMi1rs7k%2Fs1600%2FPing_pong_1.jpg&f=1&nofb=1");
        embedBuilder.setFooter("Ping Pong is a legitimate sport");
        embedBuilder.setColor(Color.blue);
        embedBuilder.setAuthor("Xemor");
        return embedBuilder.build();
    }

}
