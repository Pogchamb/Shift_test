package pa.chan.shift_test.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.shift_test.R
import pa.chan.shift_test.domain.model.CardInfoModel

class CardAdapter(private val cardInfoModelList: List<CardInfoModel>) :
    RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val cardViewItem = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return  CardViewHolder(cardViewItem)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cardInfoModelList[position])
    }

    override fun getItemCount(): Int {
        return cardInfoModelList.size
    }
}