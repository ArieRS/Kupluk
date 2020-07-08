package kupluk.smk.coding.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    companion object {
        val suratBaseUrl = "https://api.banghasan.com/"
        val getSuratServices: ApiServices
            get() {
                val r = Retrofit.Builder()
                    .baseUrl(suratBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                return r.create(ApiServices::class.java)
            }
    }
}