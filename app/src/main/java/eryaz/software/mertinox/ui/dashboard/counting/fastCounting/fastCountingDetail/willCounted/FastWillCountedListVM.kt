package eryaz.software.mertinox.ui.dashboard.counting.fastCounting.fastCountingDetail.willCounted

import eryaz.software.mertinox.data.models.dto.CountingComparisonDto
import eryaz.software.mertinox.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FastWillCountedListVM(productList: List<CountingComparisonDto>) : BaseViewModel() {
    private val _list = MutableStateFlow(productList)
    val list = _list.asStateFlow()

    fun updateProductQuantity(productId: Int, quantity: Int) {
        _list.value.find {
            it.productDto.id == productId
        }?.newQuantity?.set(quantity.toString())
    }
}
