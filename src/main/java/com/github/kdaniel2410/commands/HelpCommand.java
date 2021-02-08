package com.github.kdaniel2410.commands;

import com.github.kdaniel2410.Constants;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import de.btobastian.sdcf4j.CommandHandler;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class HelpCommand implements CommandExecutor {

    private final CommandHandler handler;

    public HelpCommand(CommandHandler handler) {
        this.handler = handler;
    }

    @Command(aliases = {">help"})
    public void onCommand(TextChannel channel, Message message) {
        StringBuilder string = new StringBuilder();
        handler.getCommands().forEach(command -> {
            String usage = command.getCommandAnnotation().usage();
            if (usage.isEmpty()) {
                usage = command.getCommandAnnotation().aliases()[0];
            }
            string.append(usage);
            string.append("\n");
        });
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Constants.EMBED_COLOR)
                .setDescription("Here is a list of all the commands I can perform.\n\n" + string.toString())
                .setFooter("If you delete your original message, this response will be deleted.");
        channel.sendMessage(embed).thenAccept(response -> message.addMessageDeleteListener(event -> response.delete()));
    }
}
