package com.infy.newsmvvm.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("title")
    var title:String?="",
    @SerializedName("rows")
    var newsDetails:ArrayList<NewsDetails> = arrayListOf()
)
