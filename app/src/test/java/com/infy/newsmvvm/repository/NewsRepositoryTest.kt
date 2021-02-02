package com.infy.newsmvvm.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.infy.newsmvvm.model.NewsResponse
import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    val repository : NewsRepository = NewsRepository()

    @Test
    fun getNewsDetails() {
        `when`(repository.getNewsDetails()).thenReturn(Observable.just(NewsResponse()))
        verify(repository.getNewsDetails())
    }
}