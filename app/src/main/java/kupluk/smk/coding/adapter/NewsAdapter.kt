package kupluk.smk.coding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kupluk.smk.coding.R
import kupluk.smk.coding.data.News

class NewsAdapter internal constructor(
    private val news: ArrayList<News>,
    private val context: Context
) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsHolder {
        return NewsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsAdapter.NewsHolder, position: Int) {
        holder.bind(news[position])
    }

    inner class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_news)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_news_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_news_description)
        fun bind(news: News) {
            Glide.with(context)
                .load(news.image)
                .into(imgPhoto)
            tvTitle.text = news.title
            tvDescription.text = news.description
        }
    }
}