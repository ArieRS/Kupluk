package kupluk.smk.coding.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_jadwal_sholat.*
import kupluk.smk.coding.R
import kupluk.smk.coding.api.Api
import kupluk.smk.coding.data.jadwal.Data
import kupluk.smk.coding.data.jadwal.jadwal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class JadwalSholatActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_sholat)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        supportActionBar?.title = Html.fromHtml("<font color=#44C121>${getString(R.string.app_name)}</font>")
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)


        fetchJson()
    }

    private fun fetchJson() {
        val current = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val formattedDate = formatter.format(current)

        val call: Call<jadwal> = Api.getSuratServices.getJadwal(formattedDate)
        call.enqueue(object : Callback<jadwal> {
            override fun onFailure(call: Call<jadwal>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<jadwal>, response: Response<jadwal>) {
                response.body()?.jadwal?.data.let { setShalatTime(it) }
            }

        })
    }

    private fun setShalatTime(jadwalShalat: Data?) {
        jadwal_shubuh.text = jadwalShalat?.subuh
        jadwal_dhuha.text = jadwalShalat?.dhuha
        jadwal_dzuhur.text = jadwalShalat?.dzuhur
        jadwal_ashar.text = jadwalShalat?.ashar
        jadwal_maghrib.text = jadwalShalat?.maghrib
        jadwal_isya.text = jadwalShalat?.isya
        Toast.makeText(this, "Sukses mendapatkan jadwal :)", Toast.LENGTH_SHORT).show()
    }

//    private fun callShalatTime() {
//
//        val current = Calendar.getInstance().time
//        val formatter = SimpleDateFormat("yyyy-MM-dd")
//        val formattedDate = formatter.format(current)
//
//        val httpClient = httpClient()
//        val apiRequest = apiRequest<RetrofitService>(httpClient)
//
//        val call = apiRequest.getDate(formattedDate)
//        call.enqueue(object : Callback<DateResponse> {
//
//            override fun onFailure(call: Call<DateResponse>, t: Throwable) {
//                Toast.makeText(context, "Gagal mendapatkan data :(", Toast.LENGTH_SHORT)
//                    .show()
//                Log.e("error", t.toString())
//            }
//
//            override fun onResponse(
//                call: Call<DateResponse>,
//                response: Response<DateResponse>
//            ) {
//                when {
//                    response.isSuccessful ->
//                        response.body()?.jadwal?.data.let { setShalatTime(it) }
////                        response.body()?.let { setShalatTime(it) }
//                    else -> {
//                        Toast.makeText(context, "Gagal :(", Toast.LENGTH_SHORT)
//                            .show()
//                        Log.e("error", response.body()?.status)
//                    }
//                }
//            }
//        })
//    }

}