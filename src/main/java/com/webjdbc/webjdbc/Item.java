package com.webjdbc.webjdbc;

public class Item {
    private String title;
    private int timestamp;
    private String desc;
    private boolean done;

    public Item(String title, int timestamp, String desc, boolean done) {
        this.title = title;
        this.timestamp = timestamp;
        this.desc = desc;
        this.done = done;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.desc;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public boolean getDone() {
        return this.done;
    }

    @Override
    public String toString() {
        return String.format("Item with title (%s) timestamp (%d) description (%s) and done (%s).", this.title, this.timestamp, this.desc, this.done);
    }

}
