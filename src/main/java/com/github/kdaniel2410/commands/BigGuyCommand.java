package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class BigGuyCommand implements CommandExecutor {

    @Command(aliases = {">bigguy"})
    public String onCommand(String[] args) {
        return "https://i.imgur.com/MGxEt1F.png";
    }
}
