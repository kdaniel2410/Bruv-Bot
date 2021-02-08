package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class BadPostCommand implements CommandExecutor {

    @Command(aliases = {">badpost"})
    public String onCommand() {
        return "https://i.imgur.com/JCqYwmp.png";
    }
}
