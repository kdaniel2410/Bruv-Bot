package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class GizmoCommand implements CommandExecutor {

    @Command(aliases = {">gizmo", ">cat"})
    public String onCommand() {
        return "https://i.imgur.com/4kLMPtB.png";
    }
}
