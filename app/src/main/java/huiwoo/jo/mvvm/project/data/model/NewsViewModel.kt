package huiwoo.jo.mvvm.project.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel() {
    private val _newsList = MutableLiveData<ArrayList<News>>()
    val newsList : LiveData<ArrayList<News>>
        get() = _newsList

    //data for test
    private val title = "news"
    private val author = "author"
    private val time = "2024-01-18"
    private val elapsed = "7hour ago"
    private val content = "test"
    private val url = "img.url" //url 수정 필요
    private val items = arrayListOf(
        News(title,author,url, content, time, elapsed)
    )

    init{
        _newsList.value = items
    }
}