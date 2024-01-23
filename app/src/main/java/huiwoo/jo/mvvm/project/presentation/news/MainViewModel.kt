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

}

