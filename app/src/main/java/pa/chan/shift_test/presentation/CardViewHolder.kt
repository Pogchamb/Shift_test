package pa.chan.shift_test.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pa.chan.shift_test.R
import pa.chan.shift_test.domain.model.CardInfoModel
import pa.chan.shift_test.domain.model.CountryModel

class CardViewHolder(
    view: View,
    private val onPhoneClick: (String) -> Unit,
    private val onUrlClick: (String) -> Unit,
    private val onCoordinateClick: (country: CountryModel) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val schemeText: TextView = view.findViewById(R.id.schemeText)
    private val brandText: TextView = view.findViewById(R.id.brandText)
    private val lengthText: TextView = view.findViewById(R.id.lengthText)
    private val luhnText: TextView = view.findViewById(R.id.luhnText)
    private val typeText: TextView = view.findViewById(R.id.typeText)
    private val prepaidText: TextView = view.findViewById(R.id.prepaidText)
    private val countryText: TextView = view.findViewById(R.id.countryText)
    private val coordinate: TextView = view.findViewById(R.id.coordinate)
    private val bankName: TextView = view.findViewById(R.id.bankName)
    private val bankCity: TextView = view.findViewById(R.id.bankCity)
    private val bankUrl: TextView = view.findViewById(R.id.bankUrl)
    private val bankTel: TextView = view.findViewById(R.id.bankTel)

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
        cardInfoModel.country?.let {
            coordinate.setOnClickListener {
                onCoordinateClick.invoke(cardInfoModel.country)
            }
        }
        bankName.text = cardInfoModel.bank?.name ?: "-"
        bankCity.text = cardInfoModel.bank?.city ?: "-"
        bankUrl.text = cardInfoModel.bank?.url ?: "-"
        cardInfoModel.bank?.url?.let {
            bankUrl.setOnClickListener {
                onUrlClick.invoke(cardInfoModel.bank.url)
            }
        }
        bankTel.text = cardInfoModel.bank?.phone ?: "-"
        cardInfoModel.bank?.phone?.let {
            bankTel.setOnClickListener {
                onPhoneClick.invoke(cardInfoModel.bank.phone)
            }
        }
    }
}