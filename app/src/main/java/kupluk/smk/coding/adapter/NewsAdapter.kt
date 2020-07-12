package kupluk.smk.coding.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.database.FirebaseDatabase
import kupluk.smk.coding.R
import kupluk.smk.coding.activity.NewsActivity
import kupluk.smk.coding.activity.NewsDetailActivity
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
        holder.itemView.setOnClickListener {
            val items = arrayOf("Update", "Delete", "Detail")
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle(news[position].title)
                .setItems(items) {dialog, i ->
                    when (i) {
                        0 -> updateNews(news[position])
                        1 -> deleteNews(news[position])
                        2 -> showDetails(news[position])
                    }
                }.show()
        }
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

    private fun updateNews(news: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra("EXTRA_TITLE", news.title)
        intent.putExtra("EXTRA_DESCRIPTION", news.description)
        intent.putExtra("EXTRA_IMAGE", news.image)
        intent.putExtra("EXTRA_KEY", news.key)
        intent.putExtra("EXTRA_UPDATE", 1)
        context.startActivity(intent)
    }

    private fun deleteNews(news: News) {
        val ref = FirebaseDatabase.getInstance().reference
        ref.child("uploads")
            .child(news.key)
            .removeValue()
            .addOnSuccessListener {
                Toast.makeText(context, "Berhasil Hapus", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showDetails(news: News) {
        val intent = Intent(context, NewsDetailActivity::class.java)
        intent.putExtra("EXTRA_TITLE", news.title)
        intent.putExtra("EXTRA_DESCRIPTION", news.description)
        intent.putExtra("EXTRA_IMAGE", news.image)
        context.startActivity(intent)
    }
}