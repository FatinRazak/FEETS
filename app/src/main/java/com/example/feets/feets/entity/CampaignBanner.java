package com.example.feets.feets.entity;

/**
 * A class for campaign banner homepage
 */
public class CampaignBanner {
    private String current_booster;
    private String rank;
    private String points;
    private String event_start;
    private String event_end;

    public String getCurrent_booster() {
        return current_booster;
    }

    public void setCurrent_booster(String current_booster) {
        this.current_booster = current_booster;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getEvent_start() {
        return event_start;
    }

    public void setEvent_start(String event_start) {
        this.event_start = event_start;
    }

    public String getEvent_end() {
        return event_end;
    }

    public void setEvent_end(String event_end) {
        this.event_end = event_end;
    }
}
