package pa.chan.shift_test.data.dto.extantion

import pa.chan.shift_test.data.dto.CardInfoDto
import pa.chan.shift_test.data.dto.CardInfoEntity
import pa.chan.shift_test.domain.model.CardInfoModel

fun CardInfoDto.toEntity(): CardInfoEntity = CardInfoEntity(
    id = null,
    number = this.number,
    scheme = this.scheme,
    type = this.type,
    brand = this.brand,
    prepaid = this.prepaid,
    country = this.country,
    bank = this.bank,
    date = System.currentTimeMillis()
)

fun CardInfoEntity.toModel(): CardInfoModel = CardInfoModel(
    number = this.number,
    scheme = this.scheme,
    type = this.type,
    brand = this.brand,
    prepaid = this.prepaid,
    country = this.country,
    bank = this.bank
)