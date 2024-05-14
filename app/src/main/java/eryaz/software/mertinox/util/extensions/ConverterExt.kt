package eryaz.software.mertinox.util.extensions

import eryaz.software.mertinox.R
import eryaz.software.mertinox.data.enums.LanguageType

fun LanguageType.getDrawableRes() = when (this) {
    LanguageType.AZ -> R.drawable.ic_az
    LanguageType.EN -> R.drawable.ic_en
    LanguageType.RU -> R.drawable.ic_ru
    LanguageType.AR -> R.drawable.ic_ar
    LanguageType.TR -> R.drawable.ic_tr
}
