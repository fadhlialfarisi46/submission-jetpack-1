package com.example.submissionjetpack1.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.submissionjetpack1.R
import com.example.submissionjetpack1.data.MovieEntity
import com.example.submissionjetpack1.databinding.ActivityDetailMovieBinding
import com.example.submissionjetpack1.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var detailContentDetailMovieBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentDetailMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        with(detailContentDetailMovieBinding){
            textTitle.text = movieEntity.title
            textDescription.text = movieEntity.description
            textGenre.text = movieEntity.genre
            textRelease.text = movieEntity.release
            textRuntime.text = movieEntity.runtime

        }

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentDetailMovieBinding.image)

    }
}