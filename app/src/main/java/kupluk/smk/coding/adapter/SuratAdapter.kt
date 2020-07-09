package kupluk.smk.coding.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kupluk.smk.coding.R
import kupluk.smk.coding.activity.AyatActivity
import kupluk.smk.coding.data.surat.Hasil
import kupluk.smk.coding.data.surat.Surat

class SuratAdapter internal constructor(private val surat: ArrayList<Surat>) :
    RecyclerView.Adapter<SuratAdapter.SuratHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuratHolder {
        return SuratHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_surat, parent, false)
        )
    }

    override fun getItemCount(): Int = surat[0].hasil.size

    override fun onBindViewHolder(holder: SuratHolder, position: Int) {
        val hasil = surat[0].hasil[position]
        holder.bind(hasil)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, AyatActivity::class.java)
            intent.putExtra("EXTRA_NOMOR", hasil.nomor)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class SuratHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaSurat: TextView = itemView.findViewById(R.id.tv_nama_ayat)
        val tvArtiAyat: TextView = itemView.findViewById(R.id.tv_arti_ayat)
        fun bind(hasil: Hasil) {
            tvNamaSurat.text = hasil.nama
            tvArtiAyat.text = hasil.arti
        }
    }
}