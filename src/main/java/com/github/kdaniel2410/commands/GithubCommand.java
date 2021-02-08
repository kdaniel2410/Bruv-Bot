package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class GithubCommand implements CommandExecutor {

    @Command(aliases = {">github"})
    public String onCommand() {
        return "https://github.com/kdaniel2410/Bruv-Bot";
    }
}
