package com.example.submissionjetpack1.detail

import androidx.lifecycle.ViewModel
import com.example.submissionjetpack1.data.MovieEntity
import com.example.submissionjetpack1.utils.DataDummy

class DetailMovieViewModel: ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId:String){
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity{
        lateinit var movie: MovieEntity
        val moviesEntities = DataDummy.generateDummyMovies()
        for (movieEntity in moviesEntities){
            if (movieEntity.movieId == movieId){
                movie = movieEntity
            }
        }
        return movie
    }
}