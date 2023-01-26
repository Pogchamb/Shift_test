package pa.chan.shift_test.domain.model

import pa.chan.shift_test.data.dto.BankEntity
import pa.chan.shift_test.data.dto.CountryEntity
import pa.chan.shift_test.data.dto.NumberEntity

data class CardInfoModel(
    val number: NumberEntity?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: CountryEntity?,
    val bank: BankEntity?,
)