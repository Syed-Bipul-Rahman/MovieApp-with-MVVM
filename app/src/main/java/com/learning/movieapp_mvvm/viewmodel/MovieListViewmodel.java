package com.learning.movieapp_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.learning.movieapp_mvvm.services.model.Result;
import com.learning.movieapp_mvvm.services.repository.MovieRepository;

import java.util.List;

public class MovieListViewmodel extends AndroidViewModel {
    private MovieRepository mRepo;

    public MovieListViewmodel(@NonNull Application application) {
        super(application);
        mRepo = MovieRepository.getInstance(application);


    }


    public LiveData<List<Result>> getTopRatedMovieList() {
        return mRepo.getMovieLists();
    }
}
