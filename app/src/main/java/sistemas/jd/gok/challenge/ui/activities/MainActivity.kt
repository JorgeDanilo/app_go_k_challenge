package sistemas.jd.gok.challenge.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.domain.model.ProductResponse
import sistemas.jd.gok.challenge.domain.model.User
import sistemas.jd.gok.challenge.ui.adapters.SpotlightAdapterViewPager
import sistemas.jd.gok.challenge.ui.fragments.CashFragment
import sistemas.jd.gok.challenge.ui.fragments.ProductsFragment
import sistemas.jd.gok.challenge.viewmodel.MainViewModel
import sistemas.jd.gok.challenge.databinding.ActivityMainBinding as Binding


class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private val binding by lazy {
        DataBindingUtil.setContentView<Binding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
        viewModel.getAll()
        configureView()
        setupViewPager()
        setupObservers()
    }

    private fun configureView() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        binding?.user = User()
    }

    private fun setupObservers() {
        viewModel.products.observe(this, Observer { data ->
            binding?.viewPagerSpotligth?.adapter = SpotlightAdapterViewPager(data.spotlight, this)
            addCashFragment(data)
            addProductFragment(data)
        })
    }

    private fun addProductFragment(data: ProductResponse) {
        val productsFragment =
            ProductsFragment.newInstance(Gson().toJson(data.products))
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.productFragment, productsFragment, "productsFragment")
            .addToBackStack(null)
            .commit()
    }

    private fun addCashFragment(data: ProductResponse) {
        val cashFragment =
            CashFragment.newInstance(data.cash)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.cashFragment, cashFragment, "cashFragment")
            .addToBackStack(null)
            .commit()
    }

    private fun setupViewPager() {
        binding?.viewPagerSpotligth?.pageMargin = -60
        binding?.viewPagerSpotligth?.isHorizontalFadingEdgeEnabled = true
        binding?.viewPagerSpotligth?.setFadingEdgeLength(40)
    }
}