package com.nejtr0n.crocotime.tz.persistence.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseResult {

    @SerializedName("affected_ids")
    @Expose
    private List<Integer> affectedIds = null;

    public List<Integer> getAffectedIds() {
        return affectedIds;
    }

    public void setAffectedIds(List<Integer> affectedIds) {
        this.affectedIds = affectedIds;
    }

}