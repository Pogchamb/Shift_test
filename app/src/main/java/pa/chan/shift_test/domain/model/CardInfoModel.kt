package pa.chan.shift_test.domain.model

data class CardInfoModel(
    val number: NumberModel?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryModel?,
    val bank: BankModel?,
)

data class NumberModel(
    val length: Int?,
    val luhn: Boolean?,
)


data class CountryModel(
    val numeric: Int?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Double?,
    val longitude: Double?,
)

data class BankModel(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?,
)