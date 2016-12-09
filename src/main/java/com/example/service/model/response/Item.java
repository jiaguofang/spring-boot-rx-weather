package com.example.service.model.response;

/**
 * @author Jiaguo Fang (pue626)
 */
public class Item {

    public Item() {
    }

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Item{" +
                "condition=" + condition +
                '}';
    }
}
