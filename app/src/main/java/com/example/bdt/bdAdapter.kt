package com.example.bdt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class bdAdapter internal constructor(context: Context): RecyclerView.Adapter<bdAdapter.BDViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var bds = emptyList<DB>() // Cache copy of birthday data

    override fun onBindViewHolder(holder: BDViewHolder, position: Int) {
        val bdRecord = bds.get(position)
        holder.textViewName.text = bdRecord.name.toString()
        holder.textViewDOB.text = bdRecord.dob.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BDViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return BDViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return bds.size
    }
    inner class BDViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDOB: TextView = itemView.findViewById(R.id.textViewDOB)
    }

    internal fun setBDS(bds: List<DB>){
        this.bds = bds
        notifyDataSetChanged()
    }
}