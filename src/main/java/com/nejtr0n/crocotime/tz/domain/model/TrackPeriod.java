package com.nejtr0n.crocotime.tz.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TrackPeriod {
    @SerializedName("start")
    @Expose
    private Date start;
    @SerializedName("end")
    @Expose
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Integer getStartTime() {
        Long res = this.start.getTime() / 1000;
        return res.intValue();
    }

    public Date getEnd() {
        return end;
    }

    public Integer getEndTime() {
        Long res = this.end.getTime() / 1000;
        return res.intValue();
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
