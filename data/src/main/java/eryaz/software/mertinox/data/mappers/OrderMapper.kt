package eryaz.software.mertinox.data.mappers

import eryaz.software.mertinox.data.models.dto.ControlPointScreenDto
import eryaz.software.mertinox.data.models.dto.OrderHeaderDto
import eryaz.software.mertinox.data.models.dto.PackageDto
import eryaz.software.mertinox.data.models.dto.PackageOrderDetailDto
import eryaz.software.mertinox.data.models.dto.RouteDto
import eryaz.software.mertinox.data.models.dto.ShippingRouteDto
import eryaz.software.mertinox.data.models.dto.TransferPickingDto
import eryaz.software.mertinox.data.models.dto.TransferRequestDetailDto
import eryaz.software.mertinox.data.models.dto.TransferRequestHeaderDto
import eryaz.software.mertinox.data.models.dto.VehiclePackageDto
import eryaz.software.mertinox.data.models.remote.response.ControlPointScreenResponse
import eryaz.software.mertinox.data.models.remote.response.OrderHeaderResponse
import eryaz.software.mertinox.data.models.remote.response.PackageOrderDetailResponse
import eryaz.software.mertinox.data.models.remote.response.PackageResponse
import eryaz.software.mertinox.data.models.remote.response.RouteResponse
import eryaz.software.mertinox.data.models.remote.response.ShippingRouteResponse
import eryaz.software.mertinox.data.models.remote.response.TransferPickingResponse
import eryaz.software.mertinox.data.models.remote.response.TransferRequestDetailResponse
import eryaz.software.mertinox.data.models.remote.response.TransferRequestHeaderResponse
import eryaz.software.mertinox.data.models.remote.response.VehiclePackageResponse
import eryaz.software.mertinox.data.utils.getFormattedDate

fun OrderHeaderResponse.toDto() = OrderHeaderDto(
    id = id,
    company = company.toDto(),
    client = client?.toDto(),
    warehouse = warehouse.toDto(),
    notes = notes.orEmpty(),
    shippingType = shippingType?.toDto(),
    controlPoint = controlPoint?.toDto(),
    collectPoint = collectPoint,
    workActivity = workActivity?.toDto(),
    documentNo = documentNo,
    documentDate = documentDate.getFormattedDate("dd.MM.yyyy HH:mm")
)

fun ControlPointScreenResponse.toDto() = ControlPointScreenDto(
    id = id,
    code = code,
    definition = definition,
    status = status,
    pickerUsers = pickerUsers,
    shippingTypes = shippingTypes,
    clientNames = clientNames,
    fixName = "$shippingTypes / $pickerUsers"
)

fun PackageResponse.toDto() = PackageDto(
    company = company.toDto(),
    warehouse = warehouse.toDto(),
    orderHeader = orderHeader.toDto(),
    client = client.toDto(),
    isLocked = isLocked,
    no = no,
    id = id,
    tareWeight = tareWeight,
    sizeWidth = sizeWidth,
    sizeLength = sizeLength,
    sizeHeight = sizeHeight,
    deci = deci
)

fun TransferRequestDetailResponse.toDto() = TransferRequestDetailDto(
    id = id,
    product = product.toDto(),
    quantity = quantity.toInt().toString(),
    quantityPicked = quantityPicked.toInt().toString(),
    quantityShipped = quantityShipped.toInt().toString()
)

fun TransferPickingResponse.toDto() = TransferPickingDto(
    transferRequestDetailList = transferRequestDetailList.map { it.toDto() },
    pickingSuggestionList = pickingSuggestionList.map { it.toDto() }
)

fun RouteResponse.toDto() = RouteDto(
    id = id,
    code = code
)

fun PackageOrderDetailResponse.toDto() = PackageOrderDetailDto(
    id = id,
    product = product.toDto(),
    quantity = quantity,
    quantityShipped =quantityShipped,
    quantityCollected = quantityCollected
)

fun ShippingRouteResponse.toDto() = ShippingRouteDto(
    code = code
)

fun VehiclePackageResponse.toDto() = VehiclePackageDto(
    code = code,
    id = id,
    clientName = clientName,
    orderHeaderId = orderHeaderId,
    quantityPackTotal = quantityPackTotal,
    quantityLoadPack = quantityLoadPack,
    quantityUnLoadPack = quantityUnLoadPack,
    shippingRoute = shippingRoute.toDto()
)

fun TransferRequestHeaderResponse.toDto() = TransferRequestHeaderDto(
    id = id,
    note = note,
    shippingType = shippingType
)