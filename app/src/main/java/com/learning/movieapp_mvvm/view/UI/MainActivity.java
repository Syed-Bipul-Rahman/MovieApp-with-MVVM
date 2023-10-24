package com.learning.movieapp_mvvm.view.UI;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.movieapp_mvvm.R;
import com.learning.movieapp_mvvm.databinding.ActivityMainBinding;
import com.learning.movieapp_mvvm.services.model.Result;
import com.learning.movieapp_mvvm.view.adapter.RecyclerAdapter;
import com.learning.movieapp_mvvm.viewmodel.MovieListViewmodel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    List<Result> movilist;


    MovieListViewmodel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //init recyclerveiw
        recyclerView = findViewById(R.id.recyclerview);

        //layoutmanager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);


        //init viewmodel

        mViewModel = new ViewModelProvider(this).get(MovieListViewmodel.class);
        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                adapter = new RecyclerAdapter(MainActivity.this, results);
                recyclerView.setAdapter(adapter);


            }
        });


    }


}