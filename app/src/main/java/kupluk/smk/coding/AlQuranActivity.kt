package kupluk.smk.coding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View

class AlQuranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_al_quran)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        supportActionBar?.title = Html.fromHtml("<font color=#44C121>${getString(R.string.app_name)}</font>")
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

    }

}