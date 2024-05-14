package eryaz.software.mertinox.data.models.dto

data class TransferPickingDto(

    val transferRequestDetailList: List<TransferRequestDetailDto>,
    val pickingSuggestionList: List<PickingSuggestionDto>
)