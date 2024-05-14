package eryaz.software.mertinox.data.models.remote.response

import androidx.databinding.ObservableField
import eryaz.software.mertinox.data.enums.LanguageType

data class LanguageModel(
    val lang: LanguageType,
    val isSelected: ObservableField<Boolean>
)