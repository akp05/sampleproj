package com.rai.rough.model;

public class SlotInfo implements Comparable<SlotInfo> {
    private String text;
    private int priority;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(SlotInfo o) {
        return this.getPriority() - o.getPriority();
    }
}
