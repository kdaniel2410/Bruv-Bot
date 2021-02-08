package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class FartCommand implements CommandExecutor {

    @Command(aliases = {">fart"})
    public String onCommand() {
        return "https://www.youtube.com/watch?v=hr7GyFM7pX4";
    }
}
