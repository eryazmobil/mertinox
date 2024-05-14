package eryaz.software.mertinox.data.models.dto

data class CrossDockDto(
    val id: Int,
    val orderDetail: OrderDetailDto?,
    val quantity: Int,
    val isFinished: Boolean,
    val quantityNeed: String
)