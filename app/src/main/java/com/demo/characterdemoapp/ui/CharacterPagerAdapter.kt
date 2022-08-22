package com.demo.characterdemoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.characterdemoapp.databinding.AdapterMovieBinding


class CharacterPagerAdapter: PagingDataAdapter<CharacterDetail, CharacterPagerAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)!!
        holder.view.name.text = character.name
        Glide.with(holder.itemView.context).load(character.image).into(holder.view.imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    class CharacterViewHolder(val view: AdapterMovieBinding): RecyclerView.ViewHolder(view.root) {

    }

    object CharacterComparator : DiffUtil.ItemCallback<CharacterDetail>() {
        override fun areItemsTheSame(oldItem: CharacterDetail, newItem: CharacterDetail) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CharacterDetail, newItem: CharacterDetail) =
            oldItem == newItem
    }
}

