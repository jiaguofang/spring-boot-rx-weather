package com.example.service.model.response;

/**
 * @author Jiaguo Fang (pue626)
 */
public class Results {

    public Results() {
    }

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Results{" +
                "channel=" + channel +
                '}';
    }
}
