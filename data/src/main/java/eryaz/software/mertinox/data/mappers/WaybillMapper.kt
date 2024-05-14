package eryaz.software.mertinox.data.mappers

import eryaz.software.mertinox.data.models.dto.WaybillListDetailDto
import eryaz.software.mertinox.data.models.remote.response.WaybillListDetailResponse

fun WaybillListDetailResponse.toDto() = WaybillListDetailDto(
    product = product.toDto(),
    quantity = quantity,
    quantityOrder = quantityOrder,
    quantityPlaced = quantityPlaced,
    quantityControlled = quantityControlled.toString(),
    id = id
)