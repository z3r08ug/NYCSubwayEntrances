package com.riproad.android.interviewtestapp.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riproad.android.interviewtestapp.R
import com.riproad.android.interviewtestapp.model.SubwayEntrance
import kotlinx.android.synthetic.main.subways_item_layout.view.*

class SubwayEntranceAdapter(private val entrances: List<List<String>>?): RecyclerView.Adapter<SubwayEntranceAdapter.SubwayEntranceViewHolder>() {
    class SubwayEntranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(subwayEntrance: SubwayEntrance) {
            itemView.apply {
                subwayNameTV.text = itemView.context.getString(R.string.staion_name) + subwayEntrance.name
                subwayCoordinatesTV.text = context.getString(R.string.coordinates) + subwayEntrance.coordinates?.replace("POINT (", "")?.replace(")", "")
                subwayLinesTV.text = context.getString(R.string.lines) + subwayEntrance.lines?.replace("-", ", ")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubwayEntranceViewHolder =
            SubwayEntranceViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subways_item_layout, parent, false))

    override fun getItemCount(): Int {
        return entrances?.size!!
    }

    override fun onBindViewHolder(holder: SubwayEntranceViewHolder, position: Int) {
        holder.bind(SubwayEntrance(entrances?.get(position)?.get(10), entrances?.get(position)?.get(11), entrances?.get(position)?.get(12)))
    }

//    fun addEntrances(entrances: List<String>) {
//        this.entrances.apply {
//            clear()
//            addAll(entrances)
//        }
//    }
}