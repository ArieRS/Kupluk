package kupluk.smk.coding

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fxn.OnBubbleClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        supportActionBar?.title = Html.fromHtml("<font color=#44C121>${getString(R.string.app_name)}</font>")

        navigation()
    }

    private fun navigation() {
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        bubbleTabBar.setupBubbleTabBar(viewPager)
        bubbleTabBar.addBubbleListener(object : OnBubbleClickListener {
            override fun onBubbleClick(id: Int) {
                when (id) {
                    R.id.dashboard -> viewPager.currentItem = 0
                    R.id.kiblat -> viewPager.currentItem = 1
                    R.id.grafik -> viewPager.currentItem = 2
                    R.id.about -> viewPager.currentItem = 3
                }
            }
        })
    }
}