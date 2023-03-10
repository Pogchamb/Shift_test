package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.extansion.toEntity
import pa.chan.shift_test.data.dto.extansion.toModel
import pa.chan.shift_test.domain.CardRepository
import pa.chan.shift_test.domain.model.CardInfoModel
import java.net.UnknownHostException
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardInfoRemoteDataSource: CardInfoRemoteDataSource,
    private val cardInfoLocalDataSource: CardInfoLocalDataSource
) : CardRepository {

    override suspend fun getCardInfo(bin: Int): List<CardInfoModel> {
        return try {
            val cardInfo = cardInfoRemoteDataSource.getCardInfo(bin)
            cardInfoLocalDataSource.setCardInfo(
                cardInfo.toEntity()
            )
            getCardsInfoHistory()
        } catch (e: UnknownHostException) {
            throw e
        } catch (e: retrofit2.HttpException) {
            throw e
        }
    }

    override suspend fun getCardsInfoHistory(): List<CardInfoModel> {
        return cardInfoLocalDataSource.getCardsInfo().sortedByDescending {
            it.date
        }.map {
            it.toModel()
        }
    }

}