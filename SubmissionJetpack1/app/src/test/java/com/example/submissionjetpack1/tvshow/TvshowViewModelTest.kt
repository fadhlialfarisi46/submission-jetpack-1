package com.example.submissionjetpack1.tvshow

import junit.framework.TestCase

class TvshowViewModelTest : TestCase() {

    private lateinit var viewModel: TvshowViewModel

    public override fun setUp() {
        viewModel = TvshowViewModel()
    }

    fun testGetTvshows() {
        val tvshowentities = viewModel.getTvshows()
        assertNotNull(tvshowentities)
        assertEquals(10, tvshowentities.size)
    }
}