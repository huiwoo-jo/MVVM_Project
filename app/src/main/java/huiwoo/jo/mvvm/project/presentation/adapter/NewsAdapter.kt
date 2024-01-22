package huiwoo.jo.mvvm.project.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import huiwoo.jo.mvvm.project.data.model.News
import huiwoo.jo.mvvm.project.databinding.ItemNewsBinding
import huiwoo.jo.mvvm.project.presentation.news.MainFragment

class NewsAdapter : ListAdapter<News, NewsAdapter.NewsViewHolder>(diffUtil) {

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.news = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<News>?) {
        super.submitList(list)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}