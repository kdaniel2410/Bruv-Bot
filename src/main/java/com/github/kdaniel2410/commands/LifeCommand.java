package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class LifeCommand implements CommandExecutor {

    @Command(aliases = {">life"})
    public String onCommand() {
        return "The meaning of life, or the answer to the question: \"What is the meaning of life?\", pertains to the significance of living or existence in general. Many other related questions include: \"Why are we here?\", \"What is life all about?\", or \"What is the purpose of existence?\"";
    }
}
