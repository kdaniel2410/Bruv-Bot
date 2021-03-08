package com.github.kdaniel2410.commands;

import com.github.kdaniel2410.Constants;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RoleMeCommand implements CommandExecutor {

    @Command(aliases = {">roleme", ">rm"}, description = "Add or remove roles.", usage = ">roleme <@role>")
    public void onCommand(String[] args, Server server, TextChannel channel, User user, Message message) {
        if (message.getMentionedRoles().size() < 1 && args.length < 1) {
            sendMissingRoleMessage(server, channel)
                    .thenAccept(response -> message.addMessageDeleteListener(event -> response.delete()));
        }

        if (args[0].equals("all")) {
            server.getRoles().forEach(role -> {
                if (role.getPosition() >= getLowestRolePosition(server)) return;
                user.addRole(role).exceptionally(ExceptionLogger.get());
            });
        }

        message.getMentionedRoles().forEach(role -> {
            if (role.getPosition() >= getLowestRolePosition(server)) return;
            if (user.getRoles(server).contains(role)) user.removeRole(role);
            else user.addRole(role);
        });
    }

    private CompletableFuture<Message> sendMissingRoleMessage(Server server, TextChannel channel) {
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Constants.EMBED_COLOR)
                .setDescription("Mention the role(s) you would like adding. Hint: you can mention more than one role at once or use ``>roleme all`` to get all available roles. Here is a list of all the roles I can add or remove:\n\n" + String.join("\n", getLowerRoleTags(server)))
                .setFooter("If you delete your original message, this response will be deleted.");
        return channel.sendMessage(embed);
    }

    private int getLowestRolePosition(Server server) {
        return server.getApi().getYourself().getRoles(server).get(1).getPosition();
    }

    private List<String> getLowerRoleTags(Server server) {
        List<String> tags = new ArrayList<>();
        server.getRoles().subList(1, getLowestRolePosition(server)).forEach(role -> tags.add(role.getMentionTag()));
        return tags;
    }
}
