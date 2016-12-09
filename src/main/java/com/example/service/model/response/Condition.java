package com.example.service.model.response;

/**
 * @author Jiaguo Fang (pue626)
 */
public class Condition {

    public Condition() {
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "text='" + text + '\'' +
                '}';
    }
}
