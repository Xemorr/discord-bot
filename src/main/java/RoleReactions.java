import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;

public class RoleReactions extends ListenerAdapter {

    final long channelID = 713820152709513257L;
    HashMap<Long, Long> reactionToRoleID = new HashMap<>();

    public RoleReactions() {
        reactionToRoleID.put(683664905076736020L, 706554559899893770L); //pepe dance emote to tutorial follower
        reactionToRoleID.put(673505945380454420L, 713841191241777225L); //confused to brand new
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (e.getTextChannel().getIdLong() == channelID) {
            Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if (roleID == null) {
                return;
            }
            e.getGuild().addRoleToMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();
        }
    }

    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
        if (e.getTextChannel().getIdLong() == channelID) {
            Long roleID = reactionToRoleID.get(e.getReactionEmote().getIdLong());
            if (roleID == null) {
                return;
            }
            e.getGuild().removeRoleFromMember(e.getUserId(), e.getJDA().getRoleById(roleID)).queue();
        }
    }

}
