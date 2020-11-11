package com.riproad.android.interviewtestapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riproad.android.interviewtestapp.R
import com.riproad.android.interviewtestapp.model.Filter
import com.riproad.android.interviewtestapp.ui.main.SubwayEntrancesFragment
import com.riproad.android.interviewtestapp.util.FilterAdapter.FilterViewHolder
import kotlinx.android.synthetic.main.filter_item_layout.view.*

class FilterAdapter(private val filters: ArrayList<Filter>, private val subwayEntrancesFragment: SubwayEntrancesFragment): RecyclerView.Adapter<FilterViewHolder>() {
    class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(filter: Filter) {
            itemView.apply {
                filterIV.setImageResource(filter.getImageRes())
            }
        }

        fun applyTint() {
            itemView.apply {
                filterRL.setBackgroundColor(context.getColor(R.color.design_default_color_error))
            }
        }

        fun removeTint() {
            itemView.apply {
                filterRL.setBackgroundColor(context.getColor(R.color.white))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder =
            FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.filter_item_layout, parent, false))

    override fun getItemCount(): Int = filters.size

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(filters[position])
        holder.itemView.setOnClickListener {
            last_position = if (last_position == position) {
                -1
            } else {
                position
            }
            subwayEntrancesFragment.loadFilteredEntrances(convertToChar(position), last_position)
            notifyDataSetChanged()
        }
        if (last_position == position) {
            holder.applyTint()
        }
        else {
            holder.removeTint()
        }
    }

    private fun convertToChar(position: Int): Char {
        return when (position) {
            0 -> {
                '1'
            }
            1 -> {
                '2'
            }
            2 -> {
                '3'
            }
            3 -> {
                '4'
            }
            4 -> {
                '5'
            }
            5 -> {
                '6'
            }
            6 -> {
                '7'
            }
            7 -> {
                'A'
            }
            8 -> {
                'B'
            }
            9 -> {
                'C'
            }
            10 -> {
                'D'
            }
            11 -> {
                'E'
            }
            12 -> {
                'F'
            }
            13 -> {
                'G'
            }
            14 -> {
                'J'
            }
            15 -> {
                'L'
            }
            16 -> {
                'M'
            }
            17 -> {
                'N'
            }
            18 -> {
                'Q'
            }
            19 -> {
                'R'
            }
            20 -> {
                'S'
            }
            21 -> {
                'V'
            }
            22 -> {
                'W'
            }
            else -> {
                'Z'
            }
        }
    }

    fun addFilters(filters: List<Filter>) {
        this.filters.apply {
            clear()
            addAll(filters)
        }
    }

    companion object {
        var last_position = -1
        var already_selected = false
    }
}