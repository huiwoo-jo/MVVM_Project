package huiwoo.jo.mvvm.project.presentation.news

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import huiwoo.jo.mvvm.project.data.model.News

@SuppressLint("SuspiciousIndentation")
class MainViewModel : ViewModel() {
    private val _newsList = MutableLiveData<ArrayList<News>>()
    val newsList: LiveData<ArrayList<News>>
        get() = _newsList

    private val items: ArrayList<News> = arrayListOf(
        News(
            "news title",
            "author",
            "https://cdn.pixabay.com/photo/2021/08/03/07/03/orange-6518675_960_720.jpg",
            "test",
            "2024-01-18",
            "7hour ago"
        ),
        News(
            "news title2",
            "author",
            "https://t1.daumcdn.net/cfile/tistory/2511E03B577BB58733",
            "test",
            "2024-01-18",
            "7hour ago"
        )
    )

    init {
        _newsList.value = items
    }

}

