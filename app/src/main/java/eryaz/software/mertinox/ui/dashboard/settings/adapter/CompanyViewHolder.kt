package eryaz.software.mertinox.ui.dashboard.settings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eryaz.software.mertinox.data.models.dto.CompanyDto
import eryaz.software.mertinox.databinding.ItemDiaglogBinding

class CompanyViewHolder(val binding: ItemDiaglogBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        dto: CompanyDto, onItemClick: (
            CompanyDto
        ) -> Unit
    ) {
        binding.itemText.text = dto.code

        binding.root.setOnClickListener {
            onItemClick(dto)
        }
    }

    companion object {
        fun from(parent: ViewGroup): CompanyViewHolder {
            val binding = ItemDiaglogBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return CompanyViewHolder(binding)
        }
    }
}