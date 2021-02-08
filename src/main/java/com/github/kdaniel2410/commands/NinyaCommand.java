package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class NinyaCommand implements CommandExecutor {

    @Command(aliases = {">ninya"})
    public String onCommand() {
        return "https://www.twitch.tv/ILS_Bry";
    }
}
