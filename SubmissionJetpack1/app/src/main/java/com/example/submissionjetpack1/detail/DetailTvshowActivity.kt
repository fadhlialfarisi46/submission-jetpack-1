package com.example.submissionjetpack1.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.submissionjetpack1.R
import com.example.submissionjetpack1.data.TvShowEntity
import com.example.submissionjetpack1.databinding.ActivityDetailMovieBinding
import com.example.submissionjetpack1.databinding.ContentDetailMovieBinding

class DetailTvshowActivity : AppCompatActivity() {

    private lateinit var detailContentDetailMovieBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentDetailMovieBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvshowId = extras.getString(EXTRA_TVSHOW)
            if (tvshowId != null) {
                viewModel.setSelectedTvshow(tvshowId)
                populateTvshow(viewModel.getTvshow())
            }
        }
    }

    private fun populateTvshow(tvshowEntity: TvShowEntity) {
        with(detailContentDetailMovieBinding){
            textTitle.text = tvshowEntity.title
            textDescription.text = tvshowEntity.description
            textGenre.text = tvshowEntity.genre
            textRelease.text = tvshowEntity.release
            textRuntime.text = tvshowEntity.runtime

        }

        Glide.with(this)
            .load(tvshowEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailContentDetailMovieBinding.image)

    }
}