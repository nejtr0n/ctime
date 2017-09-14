package com.nejtr0n.crocotime.tz.application;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nejtr0n.crocotime.tz.domain.model.Track;
import com.nejtr0n.crocotime.tz.domain.repository.TrackRepository;
import com.nejtr0n.crocotime.tz.ui.console.exception.ApiException;

public class Task implements TaskContract {

    @SerializedName("tracks")
    @Expose
    protected List<Track> tracks = null;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Integer> execute(TrackRepository repository) throws ApiException {
        if(this.getTracks().size() > 0) {
            if (this.getTracks().size() == 1) {
                // Single track
                return repository.save(this.getTracks().get(0));
            } else {
                return repository.saveAll(this.getTracks());
            }
        }
        throw new ApiException("Please, provide tracks to insert");
    }
}
