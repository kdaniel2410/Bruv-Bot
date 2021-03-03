package com.github.kdaniel2410.commands;

import com.github.kdaniel2410.Constants;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class GmodCommand implements CommandExecutor {

    @Command(aliases = {">garrysmod", ">gmod"})
    public void onCommand(TextChannel channel, Message message) {
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Constants.EMBED_COLOR)
                .setDescription("Murder server: steam://connect/207.180.217.2/27015\n" +
                        "Trouble in Terrorist Town server: steam://connect/207.180.217.2/27016\n" +
                        "PropHunt (Hide'n'Seek) server: steam://connect/207.180.217.2/27017");

        channel.sendMessage(embed).thenAccept(response -> message.addMessageDeleteListener(event -> response.delete()));
    }
}
