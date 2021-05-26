package com.example.submissionjetpack1.tvshow

import androidx.lifecycle.ViewModel
import com.example.submissionjetpack1.data.TvShowEntity
import com.example.submissionjetpack1.utils.DataDummy

class TvshowViewModel: ViewModel() {

    fun getTvshows(): List<TvShowEntity> = DataDummy.generateDummyTv()
}