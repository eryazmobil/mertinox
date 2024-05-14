package eryaz.software.mertinox.util.adapter.movement.packageList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eryaz.software.mertinox.data.models.dto.PackageOrderDetailDto
import eryaz.software.mertinox.databinding.ItemPackageProductListBinding

class PackageProductViewHolder(val binding: ItemPackageProductListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        dto: PackageOrderDetailDto,
    ) {
        binding.dto = dto
    }

    companion object {
        fun from(parent: ViewGroup): PackageProductViewHolder {
            val binding = ItemPackageProductListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return PackageProductViewHolder(binding)
        }
    }
}