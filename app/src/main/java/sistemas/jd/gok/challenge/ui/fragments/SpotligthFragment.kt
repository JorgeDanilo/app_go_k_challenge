package sistemas.jd.gok.challenge.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.databinding.FragmentProductsBinding
import sistemas.jd.gok.challenge.databinding.FragmentSpotligthBinding
import sistemas.jd.gok.challenge.domain.model.Product
import sistemas.jd.gok.challenge.domain.model.Spotlight
import sistemas.jd.gok.challenge.ui.adapters.SpotlightAdapterViewPager

private const val SPOTLIGTH_DATA = "SPOTLIGTH_DATA"

class SpotligthFragment : Fragment() {

    private var spotligths: List<Spotlight>? = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val data = it.getString(SPOTLIGTH_DATA)
            val typeMyType = object : TypeToken<List<Spotlight?>?>() {}.type
            spotligths = Gson().fromJson(data, typeMyType)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotligth, container, false)
        val binding = FragmentSpotligthBinding.bind(view)
        setupViewPager(binding)
        return view
    }

    private fun setupViewPager(binding: FragmentSpotligthBinding) {
        binding.viewPagerSpotligth.pageMargin = -60
        binding.viewPagerSpotligth.isHorizontalFadingEdgeEnabled = true
        binding.viewPagerSpotligth.setFadingEdgeLength(40)
        binding.viewPagerSpotligth.adapter = SpotlightAdapterViewPager(spotligths!!, requireContext())
    }

    companion object {
        @JvmStatic
        fun newInstance(spotligth: String) =
            SpotligthFragment().apply {
                arguments = Bundle().apply {
                    putString(SPOTLIGTH_DATA, spotligth)
                }
            }
    }

}