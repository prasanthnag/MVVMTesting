package com.infy.newsmvvm.api

import com.infy.newsmvvm.model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiRepository {

    @GET("facts.json")
    fun getNewsDetails(): Observable<NewsResponse>
}