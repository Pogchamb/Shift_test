package pa.chan.shift_test.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CardInfoEntity (
    @PrimaryKey val id: Int?,
    val number: NumberEntity?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryEntity?,
    val bank: BankEntity?,
    val date: Long
)

data class NumberEntity(
    val length: Int?,
    val luhn: Boolean?,
)

data class CountryEntity(
    val numeric: Int?,
    val alpha2: String?,
    val name: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,
)

data class BankEntity(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?,
)