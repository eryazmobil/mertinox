package eryaz.software.mertinox.util.adapter.dashboard.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eryaz.software.mertinox.data.models.dto.DashboardItemDto
import eryaz.software.mertinox.databinding.ItemDashboardListBinding
import eryaz.software.mertinox.util.bindingAdapter.setOnSingleClickListener
import eryaz.software.mertinox.util.extensions.onChanged

class DashboardViewHolder(val binding: ItemDashboardListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(dto: DashboardItemDto, onItemClick :(
        (DashboardItemDto)->Unit)) {
        binding.dto = dto
        dto.hasPermission.onChanged {
            binding.root.alpha = if (it) 1f else 0.5f
            binding.root.isEnabled = it
        }
        binding.root.setOnSingleClickListener {
            onItemClick(dto)
        }
    }
    companion object {
        fun from(parent: ViewGroup): DashboardViewHolder {
            val binding = ItemDashboardListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
            return DashboardViewHolder(binding)
        }
    }
}