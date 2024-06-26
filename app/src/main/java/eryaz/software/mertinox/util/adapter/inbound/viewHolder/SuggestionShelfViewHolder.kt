package eryaz.software.mertinox.util.adapter.inbound.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eryaz.software.mertinox.data.models.dto.ShelfDto
import eryaz.software.mertinox.databinding.ItemRowSuggestionShelfBinding
import eryaz.software.mertinox.util.bindingAdapter.setOnSingleClickListener

class SuggestionShelfViewHolder(val binding: ItemRowSuggestionShelfBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(
        dto: ShelfDto,
        onItemClick: ((ShelfDto) -> Unit)
    ) {
        binding.dto = dto

        binding.root.setOnSingleClickListener {
            onItemClick(dto)
        }
    }

    companion object {
        fun from(parent: ViewGroup): SuggestionShelfViewHolder {
            val binding = ItemRowSuggestionShelfBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return SuggestionShelfViewHolder(binding)
        }
    }
}