package com.tsg.tsg_dashboard.match;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="match_data")

public class match {

    @Id
    @Column(name = "match_id", unique = true, nullable = false)
    private int match_id;

    private Date date;
    private Time time;
    private String court_location;
    private String opponents;
    private int tsg_score;
    private int opp_score;

    public match() {
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getCourt_location() {
        return court_location;
    }

    public void setCourt_location(String court_location) {
        this.court_location = court_location;
    }

    public String getOpponents() {
        return opponents;
    }

    public void setOpponents(String opponents) {
        this.opponents = opponents;
    }

    public int getTsg_score() {
        return tsg_score;
    }

    public void setTsg_score(int tsg_score) {
        this.tsg_score = tsg_score;
    }

    public int getOpp_score() {
        return opp_score;
    }

    public void setOpp_score(int opp_score) {
        this.opp_score = opp_score;
    }
}
