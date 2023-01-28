package pa.chan.shift_test.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.shift_test.R
import pa.chan.shift_test.domain.model.CardInfoModel
import pa.chan.shift_test.domain.model.CountryModel

class CardAdapter(private val cardInfoModelList: List<CardInfoModel>) :
    RecyclerView.Adapter<CardViewHolder>() {
    var onUrlClick: ((String) -> Unit) = {}
    var onPhoneClick: ((String) -> Unit) = {}
    var onCoordinateClick: ((country: CountryModel) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val cardViewItem = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return CardViewHolder(cardViewItem, onPhoneClick, onUrlClick, onCoordinateClick)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardInfoModelList[position])
    }

    override fun getItemCount(): Int {
        return cardInfoModelList.size
    }
}