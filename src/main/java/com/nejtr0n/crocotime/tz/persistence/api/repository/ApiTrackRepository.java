package com.nejtr0n.crocotime.tz.persistence.api.repository;

import com.google.inject.Inject;
import com.nejtr0n.crocotime.tz.domain.model.Track;
import com.nejtr0n.crocotime.tz.domain.repository.TrackRepository;
import com.nejtr0n.crocotime.tz.persistence.api.ApiConfig;
import com.nejtr0n.crocotime.tz.persistence.api.ApiResponse;
import com.nejtr0n.crocotime.tz.persistence.api.CrocotimeApi;
import com.nejtr0n.crocotime.tz.ui.console.exception.ApiException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import retrofit2.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiTrackRepository implements TrackRepository {
    private CrocotimeApi api;
    private ApiConfig config;

    @Inject
    public ApiTrackRepository(CrocotimeApi api, ApiConfig config) {
        this.api = api;
        this.config = config;
    }

    /**
     * Save single track
     * @param track
     * @return
     * @throws ApiException
     */
    public List<Integer> save(Track track) throws ApiException {
        // Create json request
        JtwigTemplate template = JtwigTemplate.classpathTemplate("api/templates/track/create.twig");
        JtwigModel model = JtwigModel.newModel()
                .with("token", this.config.getToken())
                .with("version", this.config.getVersion())
                .with("track", track);
        String request = template.render(model);
        // Sending request
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), request);
            Response<ApiResponse> response = api.saveTrack(requestBody).execute();
            if (response.body().getError() != null) {
                throw new ApiException(response.body().getError().getMessage());
            }
            return response.body().getResult().getAffectedIds();
        } catch (IOException e) {
            throw new ApiException("I/O error in web api");
        }
    }

    /**
     *
     * @param tracks
     * @return
     * @throws ApiException
     */
    public List<Integer> saveAll(List<Track> tracks) throws ApiException {
        List<Integer> affectedIds = new ArrayList<Integer>();
        for(Track track : tracks){
            affectedIds.addAll(this.save(track));
        }
        if (affectedIds.size() == 0) {
            throw new ApiException("Zero tracks saved");
        }
        return affectedIds;
    }
}
