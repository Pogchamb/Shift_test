package pa.chan.shift_test.domain

import pa.chan.shift_test.data.CardRepository
import pa.chan.shift_test.domain.model.CardInfoModel
import javax.inject.Inject

class GetCardInfoUseCase @Inject constructor(private val cardRepository: CardRepository) {

    suspend operator fun invoke(bin: Int): List<CardInfoModel> {
        return cardRepository.getCardInfo(bin)
    }

}