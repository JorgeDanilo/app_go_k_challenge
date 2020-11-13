package sistemas.jd.gok.challenge.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.databinding.FragmentCashBinding
import sistemas.jd.gok.challenge.domain.model.Cash

private const val CASH_DATA = "CASH_DATA"

class CashFragment : Fragment() {
    private var cash: Cash? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cash = it.getSerializable(CASH_DATA) as Cash
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cash, container, false)
        val binding = FragmentCashBinding.bind(view)
        binding.cash = cash
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(cash: Cash) =
            CashFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(CASH_DATA, cash)
                }
            }
    }
}