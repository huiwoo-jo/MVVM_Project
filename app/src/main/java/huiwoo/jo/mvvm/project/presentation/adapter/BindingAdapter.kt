package huiwoo.jo.mvvm.project.presentation.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import huiwoo.jo.mvvm.project.R
import huiwoo.jo.mvvm.project.data.model.News

object BindingAdapter {
    @BindingAdapter("news")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: ArrayList<News>) {
        if (recyclerView.adapter == null) {
            val adapter = NewsAdapter()
            recyclerView.adapter = adapter
        }

        val newsAdapter = recyclerView.adapter as NewsAdapter

        newsAdapter.submitList(items.toMutableList())
    }

    @BindingAdapter("image")
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: Any) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(R.color.gray)
            .into(imageView)
    }
}