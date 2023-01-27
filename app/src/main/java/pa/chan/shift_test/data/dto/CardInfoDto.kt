package pa.chan.shift_test.data.dto

data class CardInfoDto(
    val number: NumberDto?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean,
    val country:  CountryDto?,
    val bank: BankDto?,
)

data class NumberDto(
    val length: Int?,
    val luhn: Boolean?,
)


data class CountryDto(
    val numeric: Int?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Double?,
    val longitude: Double?,
)

data class BankDto(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?,
)

