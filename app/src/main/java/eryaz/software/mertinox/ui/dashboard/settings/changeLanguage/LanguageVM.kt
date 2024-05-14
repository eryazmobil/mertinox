package eryaz.software.mertinox.ui.dashboard.settings.changeLanguage

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import eryaz.software.mertinox.data.enums.LanguageType
import eryaz.software.mertinox.data.models.remote.response.LanguageModel
import eryaz.software.mertinox.data.persistence.SessionManager
import eryaz.software.mertinox.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LanguageVM : BaseViewModel() {

    private val _langList = MutableStateFlow<List<LanguageModel>>(emptyList())
    val langList = _langList.asStateFlow()

    init {
        getLangList()
    }

    private fun getLangList() {
        viewModelScope.launch {
            val model = LanguageType.values().map {
                LanguageModel(
                    lang = it,
                    isSelected = ObservableField(it == SessionManager.language)
                )
            }

            _langList.emit(model)
        }
    }
}
