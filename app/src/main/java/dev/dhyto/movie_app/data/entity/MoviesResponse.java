package dev.dhyto.movie_app.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by izadalab on 7/8/17.
 */

public class MoviesResponse {
    @SerializedName("results")
    private List<MovieEntity> results ;

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}
