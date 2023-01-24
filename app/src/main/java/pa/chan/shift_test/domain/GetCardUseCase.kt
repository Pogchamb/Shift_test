package pa.chan.shift_test.domain

import pa.chan.shift_test.data.CardRepository
import pa.chan.shift_test.domain.entity.CardInfoModel

class GetCardInfoUseCase(private val cardRepository: CardRepository) {

    suspend operator fun invoke(bin: Int): CardInfoModel {
        return cardRepository.getCardInfo(bin)
    }

}