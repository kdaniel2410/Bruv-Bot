package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class RequestFeatureCommand implements CommandExecutor {

    @Command(aliases = {">requestfeature"})
    public String onCommand() {
        return "https://forms.gle/oDaQZoMj2YJZJnm98";
    }
}
