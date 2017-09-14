package com.nejtr0n.crocotime.tz.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("employee.id")
    @Expose
    private Integer employeeId;
    @SerializedName("task.id ")
    @Expose
    private Integer taskId;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("period")
    @Expose
    private TrackPeriod period;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TrackPeriod getPeriod() {
        return period;
    }

    public void setPeriod(TrackPeriod period) {
        this.period = period;
    }

}
