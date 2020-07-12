package kupluk.smk.coding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_qtl.view.*
import kupluk.smk.coding.R
import kupluk.smk.coding.model.QtlModel


class QtlAdapter(private val context : Context, private val list : List<QtlModel>): RecyclerView.Adapter<QtlAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=  ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_qtl,parent,false))

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list.get(position))
    }
    class ViewHolder(override val containerView : View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindItem(item: QtlModel){
            itemView.txt_waktu.text = item.waktu
            itemView.txt_surat.text = item.surat
            itemView.txt_halaman.text = item.halaman
            itemView.txt_ayat.text = item.ayat
        }
    }
}