package kupluk.smk.coding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kupluk.smk.coding.R
import kotlinx.android.synthetic.main.fragment_tasbih.*

class TasbihActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_tasbih)

        var awal = 0

        btnplus.setOnClickListener {

            var awal = awal++
            textView.setText(awal.toString())
        }
        btnReset.setOnClickListener {

            if ( awal == 0 ) {
                textView.setText(awal.toString())
            } else {
                awal = 0

            }
            textView.setText(awal.toString())
        }
    }
}