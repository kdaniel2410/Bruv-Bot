package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class CommunismCommand implements CommandExecutor {

    @Command(aliases = {">communism"})
    public String onCommand(String[] args) {
        return "https://i.imgur.com/RMjWKV9.png";
    }
}
