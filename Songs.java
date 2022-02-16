package com.company;

public class Songs {
    private String title;
    private Double duration;

    public Songs(String title, Double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
