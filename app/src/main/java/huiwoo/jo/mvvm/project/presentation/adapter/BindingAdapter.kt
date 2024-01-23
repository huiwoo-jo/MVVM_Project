package huiwoo.jo.mvvm.project.presentation.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import huiwoo.jo.mvvm.project.R
import huiwoo.jo.mvvm.project.data.model.News

@BindingAdapter("news")
fun setItems(recyclerView: RecyclerView, items: ArrayList<News>) {
    if (recyclerView.adapter == null) {
        val adapter = NewsAdapter()
        recyclerView.adapter = adapter
    }

    val newsAdapter = recyclerView.adapter as NewsAdapter

    newsAdapter.submitList(items.toMutableList())
}

@BindingAdapter("imageUrl")
fun ImageView.load(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(R.color.gray)
        .into(this)
}