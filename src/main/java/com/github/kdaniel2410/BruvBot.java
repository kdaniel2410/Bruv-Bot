package com.github.kdaniel2410;

import com.github.kdaniel2410.commands.*;
import com.github.kdaniel2410.listeners.BrianMessageListener;
import com.github.kdaniel2410.listeners.TwitterStatusListener;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.permission.Permissions;
import twitter4j.FilterQuery;
import twitter4j.TwitterStreamFactory;

public class BruvBot {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Please provide the bot token as an argument");
            System.exit(1);
        }

        DiscordApi api = new DiscordApiBuilder()
                .setToken(args[0])
                .setAllIntents()
                .login()
                .join();

        logger.info("Logged in as " + api.getYourself().getName());
        logger.info("Use the following link to invite me: " + api.createBotInvite(Permissions.fromBitmask(8)));

        CommandHandler handler = new JavacordHandler(api);

        handler.registerCommand(new BadPostCommand());
        handler.registerCommand(new BigGuyCommand());
        handler.registerCommand(new CameronCommand());
        handler.registerCommand(new CommunismCommand());
        handler.registerCommand(new FartCommand());
        handler.registerCommand(new GithubCommand());
        handler.registerCommand(new GizmoCommand());
        handler.registerCommand(new HaroldCommand());
        handler.registerCommand(new HelpCommand(handler));
        handler.registerCommand(new InspireMeCommand());
        handler.registerCommand(new InviteCommand());
        handler.registerCommand(new LifeCommand());
        handler.registerCommand(new MinecraftCommand());
        handler.registerCommand(new NinyaCommand());
        handler.registerCommand(new PingCommand());
        handler.registerCommand(new RemindMeCommand());
        handler.registerCommand(new RequestFeatureCommand());
        handler.registerCommand(new RoleMeCommand());
        handler.registerCommand(new SetAvatarCommand());

        api.addMessageCreateListener(new BrianMessageListener());

        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));

        TwitterStreamFactory twitter = new TwitterStreamFactory();
        twitter.getInstance().addListener(new TwitterStatusListener(api, Constants.MINECRAFT_CHANNEL_ID)).filter(new FilterQuery().follow(Constants.MINECRAFT_TWITTER_ID));
        twitter.getInstance().addListener(new TwitterStatusListener(api, Constants.VALORANT_CHANNEL_ID)).filter(new FilterQuery().follow(Constants.VALORANT_TWITTER_ID));
    }
}
