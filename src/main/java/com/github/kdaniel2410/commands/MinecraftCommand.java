package com.github.kdaniel2410.commands;

import com.github.kdaniel2410.Constants;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class MinecraftCommand implements CommandExecutor {

    @Command(aliases = {">minecraft", ">mc"})
    public void onCommand(TextChannel channel, Message message) {
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Constants.EMBED_COLOR)
                .setDescription("Use following address to join the vanilla server ``mc.danielkirby.co.uk``\n\n" +
                        "Use the following address to join the modded server ``rl.danielkirby.co.uk``\n\n" +
                        "A list of all planned farms for the vanilla server can be found [here](https://docs.google.com/spreadsheets/d/1Lo_7kC_atylVCPmcMrybX_gaoaCn79FOckhd_zRuSAU/edit#gid=0)");

        channel.sendMessage(embed).thenAccept(response -> message.addMessageDeleteListener(event -> response.delete()));
    }
}
