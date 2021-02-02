package com.infy.newsmvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.infy.newsmvvm.RxImmediateSchedulerRule
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.model.NewsResponse
import com.infy.newsmvvm.repository.NewsRepository
import io.reactivex.Observable
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Rule
    @JvmField
    val rxImmediateSchedulerRule = RxImmediateSchedulerRule()
    @Mock
    var repository = NewsRepository()
    lateinit var viewModel: NewsViewModel
    @Mock
    var observer: Observer<NewsResponse?>? = null

    @Mock
    val newsDetails:ArrayList<NewsDetails> = arrayListOf(NewsDetails("Beavers",
        "Beavers are second only to humans in their ability to manipulate and change their environment.",
        "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg"))

    @Mock
    val newsResponse: NewsResponse = NewsResponse("",newsDetails)


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = NewsViewModel((repository))
        //viewModel.newsDetailsLiveData.observeForever()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testApiIfSuccess() {
        `when`(repository.getNewsDetails()).thenReturn(Observable.just(newsResponse))
        viewModel.getNewsDetails()
        assertEquals("",viewModel.newsDetailsLiveData.value)
    }
}