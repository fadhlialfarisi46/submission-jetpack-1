package com.example.submissionjetpack1.detail

import com.example.submissionjetpack1.utils.DataDummy
import junit.framework.TestCase

class DetailMovieViewModelTest : TestCase() {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    public override fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    fun testGetMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
    }
}