package eryaz.software.mertinox.data.enums

enum class ResponseStatus(private val success: Boolean?) {
    OK(true),
    FAILED(false),
    NULL_DATA(null);
}