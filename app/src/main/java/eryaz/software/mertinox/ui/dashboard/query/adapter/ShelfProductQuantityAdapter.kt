package eryaz.software.mertinox.ui.dashboard.query.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eryaz.software.mertinox.data.models.dto.ProductShelfQuantityDto

class ShelfProductQuantityAdapter :
    ListAdapter<ProductShelfQuantityDto, RecyclerView.ViewHolder>(DiffCallBacksShelf) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShelfProductQuantityVH.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShelfProductQuantityVH -> {
                holder.bind(
                    dto = getItem(position),
                    isLastItem = position == itemCount.minus(1)
                )
            }
        }
    }
}

object DiffCallBacksShelf : DiffUtil.ItemCallback<ProductShelfQuantityDto>() {
    override fun areItemsTheSame(
        oldItem: ProductShelfQuantityDto,
        newItem: ProductShelfQuantityDto
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ProductShelfQuantityDto,
        newItem: ProductShelfQuantityDto
    ) = oldItem == newItem
}