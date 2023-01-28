package pa.chan.shift_test.domain

import pa.chan.shift_test.domain.model.CardInfoModel
import javax.inject.Inject

class GetCardHistoryUseCase @Inject constructor(private val cardRepository: CardRepository) {

    suspend operator fun invoke(): List<CardInfoModel> {
        return cardRepository.getCardsInfoHistory()
    }
}