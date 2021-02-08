package com.github.kdaniel2410.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class InspireMeCommand implements CommandExecutor {

    @Command(aliases = {">inspireme"})
    public String onCommand() {
        return "Building up weak parts takes a lot of patience and pure determination! Everything about this lifestyle takes patience and without it you'll find yourself stuck in a constant internal battle. Push through the pain and trust in the process in order to truly reach physical satisfaction. I'm always reminding myself \"trust in the process\" and I also tell myself to enjoy every part of it, and yes that means building up my small triceps and forearms! Today I realized just how much being patient can start to pay off. Little by little the weak areas are coming up. Now I want you to remind yourself the same thing day to day and then before you know it you'll see exactly what I'm talking about in this post! I believe in everyone with a dream, just be patient and be determined no matter what the journey throws in front of you!";
    }
}
