package kupluk.smk.coding.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ayat.*
import kupluk.smk.coding.R
import kupluk.smk.coding.adapter.AyatAdapter
import kupluk.smk.coding.api.Api
import kupluk.smk.coding.data.ayat.Ayat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AyatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayat)

        val surat = intent.getStringExtra("EXTRA_NOMOR")
        fetchJson(surat!!)
    }

    private fun fetchJson(surat: String) {
        val call: Call<Ayat> = Api.getSuratServices.getAyat(surat)
        call.enqueue(object : Callback<Ayat> {
            override fun onFailure(call: Call<Ayat>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Ayat>, response: Response<Ayat>) {
                showData(arrayListOf(response.body()!!))
            }
        })
    }

    private fun showData(data: ArrayList<Ayat>) {
        rv_ayat.apply {
            adapter = AyatAdapter(data)
            layoutManager = LinearLayoutManager(this@AyatActivity)
        }
    }
}