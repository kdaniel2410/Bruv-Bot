package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.net.MalformedURLException;
import java.net.URL;

public class SetAvatarCommand implements CommandExecutor {

    @Command(aliases = {">setavatar"}, usage = ">setavatar <url>")
    public String onCommand(String[] args, DiscordApi api, User user, Server server) {
        if (args.length < 1) return "**Error** not enough arguments";
        if (!server.hasPermission(user, PermissionType.MANAGE_SERVER)) return "**Error** you do not have the required permissions to do that";
        try {
            api.updateAvatar(new URL(args[0]));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "**Error** please provide a valid URL";
        }
        return "I've updated my avatar";
    }
}
