package com.Ihsan.elAhrar.ui.adapters

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Ihsan.elAhrar.R
import com.Ihsan.elAhrar.activities.HabitDetails
import com.Ihsan.elAhrar.data.HabitViewModel
import com.Ihsan.elAhrar.data.database.UnitHabit
import com.Ihsan.elAhrar.utils.Levels
import com.Ihsan.elAhrar.utils.Utils
import kotlinx.android.synthetic.main.one_item_habit.view.*

class HabitAdapter(
    var context: Context,
    var habitList: List<UnitHabit>,
    private val habitViewModel: HabitViewModel
) : RecyclerView.Adapter<HabitAdapter.MyViewHolder>() {

    val handler = Handler()
    private lateinit var runnable: Runnable

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
        holder.More.setOnClickListener {
            habitViewModel.deleteOne(habitList[position])
        }

        holder.cardView.setOnClickListener {
            context.startActivity(
                Intent(context, HabitDetails::class.java).putExtra(
                    "id",
                    habitList[position].id
                )
            )
        }

        runnable = object : Runnable {
            override fun run() {
                val nextLevel = Levels.getNextLevel(
                    context,
                    System.currentTimeMillis() - habitList[position].startDate!!
                )
                val passedTime =
                    (System.currentTimeMillis() - habitList[position].startDate!!).toInt()

                holder.habitProgress.progress = passedTime / nextLevel
                holder.habitProgress.bottomText =
                    Levels.getNextLevelIndex(context, nextLevel.toLong())

                holder.habitTimer.text =
                    Utils.getRemainingtimeStr(Utils.getRemainingtime(System.currentTimeMillis() - habitList[position].startDate!!))

                handler.postDelayed(this, 1000)
            }
        }
        runnable.run()

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var habitTimer = itemView.habitTimer
        var habitIcon = itemView.habitIcon
        var habitName = itemView.habitName
        var habitProgress = itemView.habitProgress
        var More = itemView.More
        var cardView = itemView.cardView
    }

    fun removeHandler() {
        try {
            handler.removeCallbacks(runnable)
        } catch (e: Exception) {
        }
    }


}