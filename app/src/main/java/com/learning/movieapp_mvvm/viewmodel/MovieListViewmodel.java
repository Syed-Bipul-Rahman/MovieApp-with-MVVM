package com.learning.movieapp_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.learning.movieapp_mvvm.services.model.Result;
import com.learning.movieapp_mvvm.services.repository.MovieAppRepository;

import java.util.List;

public class MovieListViewmodel extends AndroidViewModel {
    private MovieAppRepository mRepo;

    public MovieListViewmodel(@NonNull Application application) {
        super(application);
        mRepo = MovieAppRepository.getInstance(application);


    }


    public LiveData<List<Result>> getTopRatedMovieList() {
        return mRepo.getTopRatedMovieLists();
    }
}
