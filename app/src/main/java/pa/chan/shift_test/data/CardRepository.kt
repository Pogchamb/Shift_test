package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoDto
import pa.chan.shift_test.data.dto.CardInfoEntity
import pa.chan.shift_test.domain.entity.CardInfoModel

class CardRepository(
    private val cardInfoRemoteDataSource: CardInfoRemoteDataSource,
    private val cardInfoLocalDataSource: CardInfoLocalDataSource
) {

    suspend fun getCardInfo(bin: Int): CardInfoDto {
        val cardInfo = cardInfoRemoteDataSource.getCardInfo(bin)
        cardInfoLocalDataSource.setCardInfo(
            CardInfoEntity(
                id = null,
                number = cardInfo.number,
                scheme = cardInfo.scheme,
                type = cardInfo.type,
                brand = cardInfo.brand,
                prepaid = cardInfo.prepaid,
                country = cardInfo.country,
                bank = cardInfo.bank,
            ))
        return cardInfo
    }

    suspend fun getCardsInfoHistory(): List<CardInfoEntity> {
        return cardInfoLocalDataSource.getCardsInfo()
    }

}