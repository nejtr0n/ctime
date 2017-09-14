package com.nejtr0n.crocotime.tz.domain.repository;

import com.nejtr0n.crocotime.tz.domain.model.Track;
import com.nejtr0n.crocotime.tz.ui.console.exception.ApiException;
import java.util.List;

public interface TrackRepository {
    List<Integer> save(Track track) throws ApiException;
    List<Integer> saveAll(List<Track> tracks) throws ApiException;
}
