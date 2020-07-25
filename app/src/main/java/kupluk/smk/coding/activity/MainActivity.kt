package kupluk.smk.coding.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fxn.OnBubbleClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kupluk.smk.coding.R
import kupluk.smk.coding.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation()
    }

    private fun navigation() {
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        bubbleTabBar.setupBubbleTabBar(viewPager)
        bubbleTabBar.addBubbleListener(object : OnBubbleClickListener {
            override fun onBubbleClick(id: Int) {
                when (id) {
                    R.id.dashboard -> {
                        viewPager.currentItem = 0
                        supportActionBar?.title = "Dashboard"
                    }
//                    R.id.kiblat -> {
//                        viewPager.currentItem = 1
//                        supportActionBar?.title = "Kiblat"
//                    }
//                    R.id.grafik -> {
//                        viewPager.currentItem = 2
//                        supportActionBar?.title = "Grafik"
//                    }
                    R.id.news -> {
                        viewPager.currentItem = 2
                        supportActionBar?.title = "News"
                    }
//                    R.id.tasbih -> {
//                        viewPager.currentItem = 3
//                        supportActionBar?.title = "Tasbih"
//                    }
                }
            }
        })
    }
}