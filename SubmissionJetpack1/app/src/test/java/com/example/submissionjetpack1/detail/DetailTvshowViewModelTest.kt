package com.example.submissionjetpack1.detail

import com.example.submissionjetpack1.utils.DataDummy
import junit.framework.TestCase

class DetailTvshowViewModelTest : TestCase() {

    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTv()[0]
    private val movieId = dummyTvshow.movieId

    public override fun setUp() {
        viewModel = DetailTvshowViewModel()
        viewModel.setSelectedTvshow(movieId)
    }

    fun testGetTvshow() {
        viewModel.setSelectedTvshow(dummyTvshow.movieId)
        val tvShowEntity = viewModel.getTvshow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvshow.movieId, tvShowEntity.movieId)
        assertEquals(dummyTvshow.title, tvShowEntity.title)
        assertEquals(dummyTvshow.description, tvShowEntity.description)
        assertEquals(dummyTvshow.genre, tvShowEntity.genre)
        assertEquals(dummyTvshow.release, tvShowEntity.release)
        assertEquals(dummyTvshow.runtime, tvShowEntity.runtime)
        assertEquals(dummyTvshow.imagePath, tvShowEntity.imagePath)
    }
}