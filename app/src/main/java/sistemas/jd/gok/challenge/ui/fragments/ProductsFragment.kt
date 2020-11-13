package sistemas.jd.gok.challenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.databinding.FragmentProductsBinding
import sistemas.jd.gok.challenge.domain.model.Product
import sistemas.jd.gok.challenge.ui.adapters.ProductAdapter
import sistemas.jd.gok.challenge.utils.LinePagerIndicatorDecoration


private const val PRODUCT_DATA = "PRODUCT_DATA"

class ProductsFragment : Fragment() {
    private var products: List<Product>? = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeData()
    }

    private fun initializeData() {
        arguments?.let {
            val data = it.getString(PRODUCT_DATA)
            val typeMyType = object : TypeToken<List<Product?>?>() {}.type
            products = Gson().fromJson(data, typeMyType)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        val binding = FragmentProductsBinding.bind(view)
        setupViewPager(binding)
        return view
    }

    private fun setupViewPager(binding: FragmentProductsBinding) {
        binding.recyclerViewProducts.addItemDecoration(LinePagerIndicatorDecoration())
        binding.recyclerViewProducts.adapter = ProductAdapter(products!!)
    }

    companion object {
        @JvmStatic
        fun newInstance(products: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(PRODUCT_DATA, products)
                }
            }
    }
}