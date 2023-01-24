package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoEntity

class CardInfoLocalDataSource(private val cardInfoDao: CardInfoDao) {

    suspend fun getCardsInfo(): List<CardInfoEntity> {
        return cardInfoDao.getAll()
    }

    suspend fun setCardInfo(cardInfo: CardInfoEntity) {
        cardInfoDao.insert(cardInfo)
    }

}