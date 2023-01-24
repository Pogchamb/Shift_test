package pa.chan.shift_test.domain

import pa.chan.shift_test.data.CardRepository
import pa.chan.shift_test.domain.entity.CardInfoModel

class GetCardHistoryUseCase(private val cardRepository: CardRepository){

    suspend operator fun invoke(): List<CardInfoModel>  {
        return cardRepository.getCardsInfoHistory()
    }
}