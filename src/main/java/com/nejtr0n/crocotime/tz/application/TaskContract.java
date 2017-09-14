package com.nejtr0n.crocotime.tz.application;

import com.nejtr0n.crocotime.tz.domain.repository.TrackRepository;
import java.util.List;

public interface TaskContract {
    List<Integer> execute(TrackRepository repository);
}
