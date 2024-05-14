package eryaz.software.mertinox.data.mappers

import eryaz.software.mertinox.data.models.dto.ErrorDto
import eryaz.software.mertinox.data.models.remote.response.ErrorModel

fun ErrorModel.toDto() = ErrorDto(
    code = code,
    message = message
)