package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoDto

class CardInfoRemoteDataSource(
    private val cardInfoApi: CardInfoApi
) {
    suspend fun getCardInfo(bin: Int): CardInfoDto {
        return cardInfoApi.getCardInfo(bin)
    }
}