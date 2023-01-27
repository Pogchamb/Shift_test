package pa.chan.shift_test.presentation

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pa.chan.shift_test.R
import pa.chan.shift_test.domain.model.CardInfoModel

class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val schemeText: TextView = view.findViewById(R.id.schemeText)
    private val brandText: TextView = view.findViewById(R.id.brandText)
    private val lengthText: TextView = view.findViewById(R.id.lengthText)
    private val luhnText: TextView = view.findViewById(R.id.luhnText)
    private val typeText: TextView = view.findViewById(R.id.typeText)
    private val prepaidText: TextView = view.findViewById(R.id.prepaidText)
    private val countryText: TextView = view.findViewById(R.id.countryText)
    private val coordinate: TextView = view.findViewById(R.id.coordinate)
    private val bankText: TextView = view.findViewById(R.id.bankText)

    fun bind(cardInfoModel: CardInfoModel) {
        schemeText.text = cardInfoModel.scheme ?: "-"
        brandText.text = cardInfoModel.brand ?: "-"
        lengthText.text = cardInfoModel.number?.length?.toString() ?: "-"
        luhnText.text = if (cardInfoModel.number?.luhn == true) "Yes" else "No"
        typeText.text = cardInfoModel.type ?: "-"
        prepaidText.text = if (cardInfoModel.prepaid == true) "Yes" else "No"
        countryText.text =
            "${cardInfoModel.country?.emoji ?: "-"} ${cardInfoModel.country?.name ?: "-"}"
        coordinate.text =
            "(latitude ${cardInfoModel.country?.latitude ?: "-"}, longitude: ${cardInfoModel.country?.longitude ?: "-"})"
        bankText.text =
                    (cardInfoModel.bank?.name ?: "-") +
                    "\n${cardInfoModel.bank?.city ?: "-"}" +
                    "\n${cardInfoModel.bank?.url ?: "-"}" +
                    "\n${cardInfoModel.bank?.phone ?: "-"}"
    }
}