package com.example.submissionjetpack1.movie

import junit.framework.TestCase

class MovieViewModelTest : TestCase() {

    private lateinit var viewModel: MovieViewModel

    public override fun setUp() {
        viewModel = MovieViewModel()
    }

    fun testGetMovies() {
        val movientities = viewModel.getMovies()
        assertNotNull(movientities)
        assertEquals(10, movientities.size)
    }
}