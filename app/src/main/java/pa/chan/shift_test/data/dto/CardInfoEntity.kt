package pa.chan.shift_test.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CardInfoEntity (
    @PrimaryKey val id: Int?,
    val number: NumberEntity,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryEntity,
    val bank: BankEntity
)