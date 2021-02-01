package com.infy.newsmvvm.model

import com.google.gson.annotations.SerializedName

data class NewsDetails(
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("imageHref")
    var imageRef: String? = ""
)