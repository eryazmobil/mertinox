package eryaz.software.mertinox.data.mappers

import eryaz.software.mertinox.data.models.dto.ClientDto
import eryaz.software.mertinox.data.models.remote.response.ClientSmallResponse

fun ClientSmallResponse.toDto() = ClientDto(
    id = id,
    code = code,
    name = name ?: "Hatalı işlem"
)