package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class CameronCommand implements CommandExecutor {

    @Command(aliases = {">cameron"})
    public String onCommand() {
        return "https://i.imgur.com/gHtuHEi.png";
    }
}
