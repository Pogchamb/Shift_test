package pa.chan.shift_test.data.dto.extansion

import pa.chan.shift_test.data.dto.*
import pa.chan.shift_test.domain.model.BankModel
import pa.chan.shift_test.domain.model.CardInfoModel
import pa.chan.shift_test.domain.model.CountryModel
import pa.chan.shift_test.domain.model.NumberModel

fun CardInfoDto.toEntity(): CardInfoEntity = CardInfoEntity(
    id = null,
    number = NumberEntity(
        this.number?.length,
        this.number?.luhn
    ),
    scheme = this.scheme,
    type = this.type,
    brand = this.brand,
    prepaid = this.prepaid,
    country = CountryEntity(
        this.country?.numeric,
        this.country?.alpha2,
        this.country?.name,
        this.country?.emoji,
        this.country?.currency,
        this.country?.latitude,
        this.country?.longitude
    ),
    bank = BankEntity(
        this.bank?.name,
        this.bank?.url,
        this.bank?.phone,
        this.bank?.city
    ),
    date = System.currentTimeMillis()
)

fun CardInfoEntity.toModel(): CardInfoModel = CardInfoModel(
    number =    NumberModel(
        this.number?.length,
        this.number?.luhn
    ),
    scheme = this.scheme,
    type = this.type,
    brand = this.brand,
    prepaid = this.prepaid,
    country = CountryModel(
        this.country?.numeric,
        this.country?.alpha2,
        this.country?.name,
        this.country?.emoji,
        this.country?.currency,
        this.country?.latitude,
        this.country?.longitude
    ),
    bank = BankModel(
        this.bank?.name,
        this.bank?.url,
        this.bank?.phone,
        this.bank?.city
    )
)