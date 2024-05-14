package eryaz.software.mertinox.data.models.dto

class ProcessDialog(
    val title: String? = "",
    var message: String? = "",
    var cancelable: Boolean = true,
    var showDialog: Boolean = true,
    var positiveButton: ButtonDto = ButtonDto(),
    var negativeButton: ButtonDto = ButtonDto(text = 0)
)