package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoEntity
import pa.chan.shift_test.data.dto.extantion.toEntity
import pa.chan.shift_test.data.dto.extantion.toModel
import pa.chan.shift_test.domain.model.CardInfoModel
import javax.inject.Inject

class CardRepository @Inject constructor(
    private val cardInfoRemoteDataSource: CardInfoRemoteDataSource,
    private val cardInfoLocalDataSource: CardInfoLocalDataSource
) {

    suspend fun getCardInfo(bin: Int): List<CardInfoModel> {
        val cardInfo = cardInfoRemoteDataSource.getCardInfo(bin)
        cardInfoLocalDataSource.setCardInfo(
            cardInfo.toEntity()
        )

        return getCardsInfoHistory()
    }

    suspend fun getCardsInfoHistory(): List<CardInfoModel> {
        return cardInfoLocalDataSource.getCardsInfo().sortedByDescending {
            it.date
        }.map {
            it.toModel()
        }
    }

}