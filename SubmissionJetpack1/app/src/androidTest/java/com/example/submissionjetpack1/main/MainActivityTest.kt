package com.example.submissionjetpack1.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.submissionjetpack1.R
import com.example.submissionjetpack1.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvshow = DataDummy.generateDummyTv()
    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_release)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release)).check(matches(withText(dummyMovie[0].release)))
    }

    @Test
    fun loadTvshows(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvshow.size))
    }

    @Test
    fun loadDetailTvshow(){
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvshow[0].title)))
        onView(withId(R.id.text_release)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release)).check(matches(withText(dummyTvshow[0].release)))
    }
}