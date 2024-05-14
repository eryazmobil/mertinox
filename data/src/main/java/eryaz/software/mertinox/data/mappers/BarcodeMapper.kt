package eryaz.software.mertinox.data.mappers

import eryaz.software.mertinox.data.models.dto.BarcodeDto
import eryaz.software.mertinox.data.models.remote.response.BarcodeResponse

fun BarcodeResponse.toDto() = BarcodeDto(
    id = id,
    product = product.toDto(),
    code = code,
    quantity = quantity
)