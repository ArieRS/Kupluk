package kupluk.smk.coding.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_al_quran.*
import kupluk.smk.coding.R
import kupluk.smk.coding.adapter.SuratAdapter
import kupluk.smk.coding.api.Api
import kupluk.smk.coding.data.surat.Surat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlQuranActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_al_quran)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        fetchJson()
    }

    private fun fetchJson() {
        val call: Call<Surat> = Api.getSuratServices.getSurat()
        call.enqueue(object : Callback<Surat> {
            override fun onFailure(call: Call<Surat>, t: Throwable) {

            }

            override fun onResponse(call: Call<Surat>, response: Response<Surat>) {
                showData(arrayListOf(response.body()!!))
            }

        })
    }

    private fun showData(data: ArrayList<Surat>) {
        rv_surat.apply {
            adapter = SuratAdapter(data)
            layoutManager = LinearLayoutManager(this@AlQuranActivity)
        }
    }

}