package com.learning.movieapp_mvvm.services.repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.learning.movieapp_mvvm.services.model.MovieModel;
import com.learning.movieapp_mvvm.services.model.Result;
import com.learning.movieapp_mvvm.services.network.ApiClient;
import com.learning.movieapp_mvvm.services.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static Context mContext;
    private static MovieRepository instance;
    private List<Result> mResult;
    private MovieModel movieModel;
    private MutableLiveData mLiveData;

    public static MovieRepository getInstance(Context context) {

        if (instance == null) {
            mContext = context;
            instance = new MovieRepository();

        }
        return instance;

    }


    public MutableLiveData<List<Result>> getMovieLists() {


        if (mLiveData == null) {
            mLiveData = new MutableLiveData();
        }


        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<MovieModel> call = apiService.getTopRatedMovieLists();

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {

                movieModel = response.body();
                mResult = movieModel.getResults();

                mLiveData.postValue(mResult);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
        return mLiveData;
    }


}
