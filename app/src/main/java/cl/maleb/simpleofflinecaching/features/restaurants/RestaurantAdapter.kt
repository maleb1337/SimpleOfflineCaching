package cl.maleb.simpleofflinecaching.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.maleb.simpleofflinecaching.data.RestaurantData
import cl.maleb.simpleofflinecaching.databinding.RestaurantItemBinding
import com.bumptech.glide.Glide

class RestaurantAdapter :
    ListAdapter<RestaurantData, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }


    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: RestaurantData) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewType.text = restaurant.type
                textViewAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<RestaurantData>() {
        override fun areItemsTheSame(oldItem: RestaurantData, newItem: RestaurantData) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: RestaurantData, newItem: RestaurantData) =
            oldItem == newItem

    }

}