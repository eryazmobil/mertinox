package eryaz.software.mertinox.ui.dashboard.recording.dialog

import androidx.lifecycle.viewModelScope
import eryaz.software.mertinox.data.api.utils.onSuccess
import eryaz.software.mertinox.data.models.dto.ProductDto
import eryaz.software.mertinox.data.persistence.SessionManager
import eryaz.software.mertinox.data.repositories.BarcodeRepo
import eryaz.software.mertinox.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ProductListDialogVM(
    private val repo: BarcodeRepo,
) : BaseViewModel() {

    private val _productList = MutableStateFlow(listOf<ProductDto>())
    val productList = _productList.asStateFlow()

    val search = MutableStateFlow("")

    init {
        search.onEach { query ->
            getAllProductList(query)
        }.launchIn(viewModelScope)
    }

   private fun getAllProductList(query: String) = executeInBackground(_uiState) {
        repo.getProductList(
            companyId = SessionManager.companyId,
            searchTxt = query,
            limit = 30
        ).onSuccess {
            _productList.emit(it)
        }
    }
}