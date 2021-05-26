package com.example.submissionjetpack1.movie

import androidx.lifecycle.ViewModel
import com.example.submissionjetpack1.data.MovieEntity
import com.example.submissionjetpack1.utils.DataDummy

class MovieViewModel: ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovies()
}