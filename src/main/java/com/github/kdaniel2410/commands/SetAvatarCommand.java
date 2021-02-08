package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.AccountUpdater;
import org.javacord.api.DiscordApi;

import java.net.MalformedURLException;
import java.net.URL;

public class SetAvatarCommand implements CommandExecutor {

    @Command(aliases = {">setavatar"}, usage = ">setavatar <url>")
    public String onCommand(String[] args, DiscordApi api) {
        if (args.length < 1) return "**Error** not enough arguments";
        try {
            api.updateAvatar(new URL(args[0]));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "**Error** please provide a valid URL";
        }
        return "I've updated my avatar";
    }
}
