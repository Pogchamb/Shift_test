package pa.chan.shift_test.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.shift_test.R

@AndroidEntryPoint
class CardInfoFragment : Fragment() {
    private lateinit var cardInfoRecyclerView: RecyclerView
    private lateinit var buttonSearch: MaterialButton
    private lateinit var inputBinEditText: TextInputEditText
    private lateinit var inputBinLayout: TextInputLayout
    private val viewModel: CardViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardInfoRecyclerView = view.findViewById(R.id.cardInfoRecyclerView)
        buttonSearch = view.findViewById(R.id.inputBinButton)
        inputBinEditText = view.findViewById(R.id.binEditText)
        inputBinLayout = view.findViewById(R.id.binInputLayout)

        cardInfoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.cardLiveData.observe(viewLifecycleOwner) {
                cardInfoRecyclerView.adapter = CardAdapter(it)
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {

            val snackbar = Snackbar.make(view, it.message, Snackbar.LENGTH_SHORT)
            snackbar.show()
        }

        inputBinEditText.addTextChangedListener {
            if (it?.length == 8) {
                inputBinLayout.isErrorEnabled = false
                buttonSearch.isEnabled = true
            } else {
                buttonSearch.isEnabled = false
                inputBinLayout.isErrorEnabled = true
                inputBinLayout.error = getString(R.string.errorInputMessage)
            }
        }

        buttonSearch.setOnClickListener {
            val bin: Int = inputBinEditText.text.toString().toInt()
            viewModel.fetchCardInfo(bin)
        }

        viewModel.fetchCardHistory()


    }
}