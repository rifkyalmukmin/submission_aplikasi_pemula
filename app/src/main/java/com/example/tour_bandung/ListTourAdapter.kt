package com.example.tour_bandung

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_bandung.databinding.ItemRowTourBinding

class ListTourAdapter(private val listTour: ArrayList<Tour>) :
    RecyclerView.Adapter<ListTourAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding =
            ItemRowTourBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listTour.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listTour[position])

    }

    class ListViewHolder(var binding: ItemRowTourBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tour: Tour) {

            binding.imgItemPhoto.setImageResource(tour.photo)
            binding.tvItemName.text = tour.name
            binding.tvItemDescription.text = tour.description

            itemView.setOnClickListener {
                val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                intentDetail.putExtra(DetailActivity.EXTRA_TOUR, tour)
                itemView.context.startActivity(intentDetail)
            }
        }
    }
}