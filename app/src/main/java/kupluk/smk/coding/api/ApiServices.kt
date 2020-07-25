package kupluk.smk.coding.api

import kupluk.smk.coding.data.ayat.Ayat
import kupluk.smk.coding.data.jadwal.jadwal
import kupluk.smk.coding.data.surat.Surat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("quran/format/json/surat")
    fun getSurat(): Call<Surat>

    @GET("quran/format/json/surat/{surat}/ayat/1-10")
    fun getAyat(@Path("surat") surat: String): Call<Ayat>

    @GET("sholat/format/json/jadwal/kota/754/tanggal/{Date}")
    fun getJadwal(@Path("Date") date: String) : Call<jadwal>
}