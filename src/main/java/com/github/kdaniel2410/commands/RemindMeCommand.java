package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.user.User;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class RemindMeCommand implements CommandExecutor {

    private final HashMap<String, TimeUnit> units = new HashMap<>();

    public RemindMeCommand() {
        units.put("seconds", TimeUnit.SECONDS);
        units.put("minutes", TimeUnit.MINUTES);
        units.put("hours", TimeUnit.HOURS);
        units.put("days", TimeUnit.DAYS);
    }

    @Command(aliases = {">remindme"}, usage = ">remindme <delay> <seconds/minutes/hours/days> <task>")
    public String onCommand(String[] args, DiscordApi api, TextChannel textChannel, User author, Message message) {
        if (args.length < 2) return "**Error** not enough arguments provided.";
        if (!units.containsKey(args[1])) return "**Error** invalid time unit.";
        long delay;
        try {
            delay =Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            return "**Error** unknown time unit use seconds, minutes, hours or days.";
        }
        api.getThreadPool().getScheduler().schedule(() -> {
            textChannel.sendMessage(author.getMentionTag() + " here is your reminder " + message.getLink());
        }, delay, units.get(args[1]));
        return "Okay, I'll remind you in " + delay + " " + args[1];
    }
}
