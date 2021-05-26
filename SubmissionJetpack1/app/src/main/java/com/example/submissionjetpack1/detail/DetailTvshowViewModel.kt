package com.example.submissionjetpack1.detail

import androidx.lifecycle.ViewModel
import com.example.submissionjetpack1.data.TvShowEntity
import com.example.submissionjetpack1.utils.DataDummy

class DetailTvshowViewModel: ViewModel() {

    private lateinit var tvshowId: String

    fun setSelectedTvshow(tvshowId:String){
        this.tvshowId = tvshowId
    }

    fun getTvshow(): TvShowEntity{
        lateinit var tvshow: TvShowEntity
        val tvshowEntities = DataDummy.generateDummyTv()
        for (tvshowEntity in tvshowEntities){
            if (tvshowEntity.movieId == tvshowId){
                tvshow = tvshowEntity
            }
        }
        return tvshow
    }
}