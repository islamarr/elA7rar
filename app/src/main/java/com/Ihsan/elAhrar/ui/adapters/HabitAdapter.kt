package com.Ihsan.elAhrar.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Ihsan.elAhrar.R
import com.Ihsan.elAhrar.data.HabitViewModel
import com.Ihsan.elAhrar.data.database.UnitHabit
import kotlinx.android.synthetic.main.one_item_habit.view.*
import java.util.concurrent.TimeUnit

class HabitAdapter(var habitList: List<UnitHabit>, val habitViewModel: HabitViewModel) :

    RecyclerView.Adapter<HabitAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.one_item_habit, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return habitList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.habitName.text = habitList[position].name
        holder.habitTimer.text = formatCounter(habitList[position].startDate)
        holder.More.setOnClickListener {
            habitViewModel.deleteOne(habitList[position])
        }
    }

    private fun formatCounter(timeInMS: Long?): String {
        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(timeInMS!!),
            TimeUnit.MILLISECONDS.toMinutes(timeInMS) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(timeInMS) % TimeUnit.MINUTES.toSeconds(1))
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var habitTimer = itemView.habitTimer
        var habitIcon = itemView.habitIcon
        var habitName = itemView.habitName
        var More = itemView.More
    }
}