package com.example.service.model.response;

/**
 * @author Jiaguo Fang (pue626)
 */
public class Channel {

    public Channel() {
    }

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "item=" + item +
                '}';
    }
}