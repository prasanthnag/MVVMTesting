package com.infy.newsmvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.infy.newsmvvm.model.NewsResponse
import com.infy.newsmvvm.repository.NewsRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {

    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    var repository = NewsRepository()
    lateinit var viewModel: NewsViewModel
    @Mock
    var observer: Observer<NewsResponse?>? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = NewsViewModel((repository))
        //viewModel.newsDetailsLiveData.observeForever()
    }

    @Test
    fun testApiWhenSuccess(){
        //`when`(repository.getNewsDetails()).thenReturn()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getNewsDetailsLiveData() {
    }
}