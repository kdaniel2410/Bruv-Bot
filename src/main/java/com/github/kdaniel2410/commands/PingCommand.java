package com.github.kdaniel2410.commands;

import com.github.kdaniel2410.Constants;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class PingCommand implements CommandExecutor {

    @Command(aliases = {">ping"})
    public void onCommand(DiscordApi api, TextChannel channel, Message message) {
        long latency = System.currentTimeMillis() - message.getCreationTimestamp().toEpochMilli();
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Constants.EMBED_COLOR);
        api.measureRestLatency().thenAccept(duration -> {
            embed.setDescription("\uD83C\uDFD3 Bot latency is ``" + latency  + "ms``. API latency is ``" + duration.toMillis() + "ms``");
            channel.sendMessage(embed);
        });
    }
}
