package kupluk.smk.coding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_news_detail.*
import kupluk.smk.coding.R

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        getData()
    }

    private fun getData() {
        tv_news_detail_title.text = intent.getStringExtra("EXTRA_TITLE")
        tv_news_detail_description.text = intent.getStringExtra("EXTRA_DESCRIPTION")
        Glide.with(this)
            .load(intent.getStringExtra("EXTRA_IMAGE"))
            .into(img_news_detail)
    }
}