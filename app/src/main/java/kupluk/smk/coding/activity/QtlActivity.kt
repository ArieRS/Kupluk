package kupluk.smk.coding.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_qtl.*
import kotlinx.android.synthetic.main.fragment_news.*
import kupluk.smk.coding.R

class QtlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qtl)

        fab_add_qtl.setOnClickListener {
            startActivity(Intent(this, AddNewQtlActivity::class.java))
        }
    }
}