package pa.chan.shift_test.domain

import pa.chan.shift_test.domain.model.CardInfoModel

interface CardRepository {
    suspend fun getCardInfo(bin: Int): List<CardInfoModel>

    suspend fun getCardsInfoHistory(): List<CardInfoModel>
}