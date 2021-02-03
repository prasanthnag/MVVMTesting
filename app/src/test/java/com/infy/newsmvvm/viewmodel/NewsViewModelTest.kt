package com.infy.newsmvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.infy.newsmvvm.RxImmediateSchedulerRule
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.model.NewsResponse
import com.infy.newsmvvm.repository.NewsRepository
import io.reactivex.Observable
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class NewsViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val rxImmediateSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    var repository = NewsRepository()

    @Mock
    lateinit var viewModel: NewsViewModel

    @Mock
    val newsDetails: ArrayList<NewsDetails> = arrayListOf(
        NewsDetails(
            "Beavers",
            "Beavers are second only to humans in their ability to manipulate and change their environment.",
            "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"
        )
    )

    @Mock
    val newsResponse: NewsResponse = NewsResponse("", newsDetails)


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = NewsViewModel(NewsRepository())
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testApiIfSuccess() {
        `when`(repository.getNewsDetails()).thenReturn(Observable.just(newsResponse))
        viewModel.getNewsDetails()
        assertEquals(newsResponse.newsDetails,viewModel.newsDetailsLiveData.value)
    }

    @Test
    fun testApiFetchDataError() {
        `when`(repository.getNewsDetails()).thenReturn(Observable.error(Throwable("Api error")))
        viewModel.getNewsDetails()
        assertEquals(newsResponse.newsDetails,viewModel.newsDetailsLiveData.value)
    }
}