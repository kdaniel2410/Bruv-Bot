package com.github.kdaniel2410.listeners;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class BrianMessageListener implements MessageCreateListener {

    String[] phrases = {"that's jarring",
            "you got that from me",
            "you're a virgin",
            "im bored of curvy girl i want a skinny one they're more fun",
            "i want to be where u will never be",
            "i want to wake up and go to places you'll never get too",
            "he's glued to his phone and looks sad or something all the time and doesn't start talks with me much like he used to",
            "xD",
            "okay Blender Guru 2.0"};

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageAuthor().isBotUser()) return;
        if (event.getMessageContent().startsWith(">") || event.getMessageContent().startsWith("!")) return;
        Random random = new Random();
        if (random.nextInt(10) == 0) {
            event.getChannel().sendMessage(phrases[random.nextInt(phrases.length)]).thenAccept(message -> event.getApi().getThreadPool().getScheduler().schedule((Callable<CompletableFuture<Void>>) message::delete, 30, TimeUnit.SECONDS));
        }
    }
}
