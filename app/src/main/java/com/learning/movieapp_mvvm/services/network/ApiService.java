package com.learning.movieapp_mvvm.services.network;

import com.learning.movieapp_mvvm.services.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("3/movie/top_rated?api_key=e27c06ee8872bade429cc658daf350f5")
    Call<MovieModel> getTopRatedMovieLists();
}
