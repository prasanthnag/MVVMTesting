package com.infy.newsmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.repository.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val newsDetailsLiveData: MutableLiveData<ArrayList<NewsDetails>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    init {
        getNewsDetails()
    }

    private fun getNewsDetails() {
        val disposable = newsRepository.getNewsDetails().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                val newsDetails = it.newsDetails
                if (newsDetails.contains(
                        NewsDetails(
                            title = null,
                            description = null,
                            imageRef = null
                        )
                    )
                )
                    newsDetails.remove(
                        NewsDetails(
                            title = null,
                            description = null,
                            imageRef = null
                        )
                    )
                newsDetailsLiveData.postValue(newsDetails)
            }, {
                newsDetailsLiveData.postValue(arrayListOf())
            })

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}