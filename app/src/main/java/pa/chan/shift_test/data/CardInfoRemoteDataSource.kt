package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoDto
import javax.inject.Inject

class CardInfoRemoteDataSource @Inject constructor(
    private val cardInfoApi: CardInfoApi
) {
    suspend fun getCardInfo(bin: Int): CardInfoDto {
        return cardInfoApi.getCardInfo(bin)
    }
}