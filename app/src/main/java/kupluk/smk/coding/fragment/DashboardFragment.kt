package kupluk.smk.coding.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kupluk.smk.coding.*
import kupluk.smk.coding.activity.*
import kupluk.smk.coding.api.Api
import kupluk.smk.coding.data.jadwal.Data
import kupluk.smk.coding.data.jadwal.jadwal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class DashboardFragment : Fragment() {
    private val handler = Handler()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler.post(object : Runnable{
            override fun run() {
                handler.postDelayed(
                    this,1000)
                fetchJson()
            }
        })

        val grid = view.findViewById(R.id.grid) as GridLayout
        val act = arrayOf(
            JadwalSholatActivity::class.java, AlQuranActivity::class.java, KalenderActivity::class.java,
            TasbihActivity::class.java, QuranLocatorActivity::class.java)
        for (i in 0 until grid.childCount) {
            val container = grid.getChildAt(i) as MaterialCardView
            container.setOnClickListener {
                startActivity(Intent(view.context, act[i]))
            }
        }
    }
    private fun updateTime(jadwalShalat: Data?) {
        val currentDate = Calendar.getInstance()
        val eventDate = Calendar.getInstance()
        var jamSkearang = currentDate[Calendar.HOUR]
        if (jamSkearang < 4){
            waktu.text = jadwalShalat?.subuh
            tv_sholat1.text = "Menjelang Subuh"
        }else if(jamSkearang == 4){
            waktu.text = jadwalShalat?.subuh
            tv_sholat1.text = "Subuh"
        }else if(jamSkearang < 6){
            waktu.text = jadwalShalat?.dhuha
            tv_sholat1.text = "Menjelang Dhuha"
        }else if(jamSkearang == 6){
            waktu.text = jadwalShalat?.dhuha
            tv_sholat1.text = "Dhuha"
        }else if(jamSkearang < 9){
            waktu.text = jadwalShalat?.dhuha
            tv_sholat1.text = "Dhuha"
        }else if(jamSkearang < 10){
            waktu.text = jadwalShalat?.dzuhur
            tv_sholat1.text = "Menjelang Dzuhur"
        }else if(jamSkearang == 11){
            waktu.text = jadwalShalat?.dzuhur
            tv_sholat1.text = "Dzuhur"
        }else if(jamSkearang < 15){
            waktu.text = jadwalShalat?.ashar
            tv_sholat1.text = "Menjelang Ashar"
        }else if(jamSkearang == 15){
            waktu.text = jadwalShalat?.ashar
            tv_sholat1.text = "Ashar"
        }else if(jamSkearang < 16){
            waktu.text = jadwalShalat?.maghrib
            tv_sholat1.text = "Menjelang Maghrib"
        }else if(jamSkearang == 17){
            waktu.text = jadwalShalat?.maghrib
            tv_sholat1.text = "Maghrib"
        }else if(jamSkearang == 18){
            waktu.text = jadwalShalat?.isya
            tv_sholat1.text = "Isya"
        }else if(jamSkearang > 18){
            waktu.text = jadwalShalat?.isya
            tv_sholat1.text = "Isya"
        }else{
            waktu.text = "EROR"
        }



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
                response.body()?.jadwal?.data.let { updateTime(it) }
            }

        })
    }


}