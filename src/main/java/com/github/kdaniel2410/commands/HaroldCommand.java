package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class HaroldCommand implements CommandExecutor {

    @Command(aliases = {">harold", ">pain"})
    public String onCommand() {
        return "https://i.imgur.com/GsOH48w.png";
    }
}
