package com.infy.newsmvvm.repository

import com.infy.newsmvvm.api.ApiRepository
import com.infy.newsmvvm.api.RetrofitInstance

class NewsRepository {

    private var service = RetrofitInstance.getRetrofitInstance().create(ApiRepository::class.java)

    fun getNewsDetails() = service.getNewsDetails()

}