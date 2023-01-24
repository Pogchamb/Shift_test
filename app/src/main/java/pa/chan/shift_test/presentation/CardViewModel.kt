package pa.chan.shift_test.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pa.chan.shift_test.domain.GetCardHistoryUseCase
import pa.chan.shift_test.domain.GetCardInfoUseCase
import pa.chan.shift_test.domain.entity.CardInfoModel

class CardViewModel(
    private val getCardInfoUseCase: GetCardInfoUseCase,
    private val getCardHistoryUseCase: GetCardHistoryUseCase,
) : ViewModel() {

    private val _cardLiveData: MutableLiveData<List<CardInfoModel>> = MutableLiveData()
    val cardLiveData: LiveData<List<CardInfoModel>>
        get() = _cardLiveData

    fun fetchCardInfo(bin: Int) {
        viewModelScope.launch {
            _cardLiveData.postValue(listOf(getCardInfoUseCase(bin)))
        }
    }

    fun fetchCardHistory() {
        viewModelScope.launch {
            _cardLiveData.postValue(getCardHistoryUseCase())
        }
    }

}