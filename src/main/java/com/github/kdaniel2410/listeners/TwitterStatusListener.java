package com.github.kdaniel2410.listeners;

import com.github.kdaniel2410.Constants;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterStatusListener implements StatusListener {

    DiscordApi api;
    long channelId;

    public TwitterStatusListener(DiscordApi api, long channelId) {
        this.api = api;
        this.channelId = channelId;
    }

    @Override
    public void onStatus(Status status) {
        if (status.isRetweet()) return;
        if (status.getInReplyToScreenName() != null) return;
        String url = "https://twitter.com/" + status.getUser().getName() + "/status/" + status.getId();
        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Constants.EMBED_COLOR)
                .setAuthor(status.getUser().getScreenName(), status.getUser().getURL(), status.getUser().getProfileImageURL())
                .setDescription(status.getText() + " /n/n Click [here](" + url + ") to go to open twitter")
                .setTimestamp(status.getCreatedAt().toInstant())
                .setFooter(status.getRetweetCount() + "\uD83D\uDD04 " + status.getFavoriteCount() + "\u2764\uFE0F");
        api.getChannelById(channelId).flatMap(Channel::asTextChannel).ifPresent(channel -> channel.sendMessage(embed));
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {

    }

    @Override
    public void onStallWarning(StallWarning warning) {

    }

    @Override
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
}
