package com.example.newsapp.features.newsloading.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.features.newsloading.data.response.News
import com.example.newsapp.features.newsloading.viewmodel.ArticleViewModel
import com.example.newsapp.features.newsloading.viewmodel.NewsViewModel

class NewsAdapter(val newsViewModel: NewsViewModel) : RecyclerView.Adapter<NewsAdapter.ArticlesViewHolder>() {
    private var items: List<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val binding: NewsItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.news_item, parent, false)
        return ArticlesViewHolder(binding, newsViewModel)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNewsList(items: List<News>) {
        this.items = items
        notifyDataSetChanged()
    }

    class ArticlesViewHolder(private val binding: NewsItemBinding,
                             private val newsViewModel: NewsViewModel) :
        RecyclerView.ViewHolder(binding.root) {
        private val articlesViewModel = ArticleViewModel()

        fun bind(character: News) {
            articlesViewModel.bind(character)
            binding.viewModel = articlesViewModel
            binding.newsViewModel = newsViewModel
        }
    }
}