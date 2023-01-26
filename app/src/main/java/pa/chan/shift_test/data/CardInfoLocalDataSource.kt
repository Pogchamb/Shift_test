package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoEntity
import javax.inject.Inject

class CardInfoLocalDataSource @Inject constructor(private val cardInfoDao: CardInfoDao) {

    suspend fun getCardsInfo(): List<CardInfoEntity> {
        return cardInfoDao.getAll()
    }

    suspend fun setCardInfo(cardInfo: CardInfoEntity) {
        cardInfoDao.insert(cardInfo)
    }

}