package com.andreyyurko.dnd.ui.spellslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andreyyurko.dnd.R
import com.andreyyurko.dnd.data.Spell

class SpellsListAdapter : RecyclerView.Adapter<SpellsListAdapter.ViewHolder>() {

    var spellsList : List<Spell> = listOf(Spell(
        name = "I will kill you",
        level = "100",
        text = "kills everyone within range",
        "", "", "", "", "", "", ""
    ))

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val spellNameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        val spellLevelTextView = itemView.findViewById<TextView>(R.id.levelTextView)
        val spellDescriptionTextView = itemView.findViewById<TextView>(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.spell, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.spellNameTextView.text = spellsList[position].name
        holder.spellLevelTextView.text = spellsList[position].level
        holder.spellDescriptionTextView.text = spellsList[position].text
    }

    override fun getItemCount(): Int {
        return spellsList.size
    }
}