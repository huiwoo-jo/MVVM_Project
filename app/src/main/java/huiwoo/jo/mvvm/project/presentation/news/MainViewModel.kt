package huiwoo.jo.mvvm.project.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import huiwoo.jo.mvvm.project.data.network.RetrofitObject

class MainViewModel: ViewModel() {
    private val _newsData: MutableLiveData<List<NewsData>> = MutableLiveData()
    val newsData: LiveData<List<NewsData>> get() = _newsData

    private fun getNewsData() {
        val fetchNews = RetrofitObject.getNews()
        fetchNews.sortedBy { it.id } // Business Logic
        fetchNews.map {
            it.content // 대문자
        }
        _newsData.value = fetchNews
    }
}

