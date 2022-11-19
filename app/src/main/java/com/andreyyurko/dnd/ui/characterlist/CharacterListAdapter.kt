package com.andreyyurko.dnd.ui.characterlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.andreyyurko.dnd.R
import com.andreyyurko.dnd.data.characters.CharacterBriefInfo

class CharacterListAdapter(
    private val viewModel: CharacterListViewModel
) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    var charactersList : List<CharacterBriefInfo> = emptyList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val classTextView: TextView = itemView.findViewById(R.id.classTextView)
        val levelTextView: TextView = itemView.findViewById(R.id.levelTextView)
        val deleteImageButton: ImageButton = itemView.findViewById(R.id.deleteImageButton)
        val mainView: ConstraintLayout = itemView.findViewById(R.id.main)
        val context: Context = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.character_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTextView.text = charactersList[position].name
        holder.classTextView.text = charactersList[position].characterClass
        holder.levelTextView.text = charactersList[position].level
        holder.mainView.setOnClickListener {
            viewModel.setShownCharacter(charactersList[position].id)
            it.findNavController().navigate(R.id.characterMainFragment)
        }
        holder.deleteImageButton.setOnClickListener {
            charactersList = viewModel.deleteCharacter(charactersList[position].id)
            notifyDataSetChanged()
        }
    }
}