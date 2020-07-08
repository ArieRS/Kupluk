package kupluk.smk.coding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kupluk.smk.coding.R
import kupluk.smk.coding.data.ayat.Ar
import kupluk.smk.coding.data.ayat.Ayat


class AyatAdapter internal constructor(private val ayat: ArrayList<Ayat>) :
    RecyclerView.Adapter<AyatAdapter.AyatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyatHolder {
        return AyatHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ayat, parent, false)
        )
    }

    override fun getItemCount(): Int = ayat[0].ayat.data.ar.size

    override fun onBindViewHolder(holder: AyatHolder, position: Int) {
        holder.bind(ayat[0].ayat.data.ar[position])
    }

    inner class AyatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAyat: TextView = itemView.findViewById(R.id.tv_ayat_nama)
        val tvText: TextView = itemView.findViewById(R.id.tv_ayat_arab)
        fun bind(ayat: Ar) {
            tvAyat.text = ayat.ayat
            tvText.text = ayat.teks
        }
    }
}