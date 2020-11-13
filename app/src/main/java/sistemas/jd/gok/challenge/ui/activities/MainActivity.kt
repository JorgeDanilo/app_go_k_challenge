package sistemas.jd.gok.challenge.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.domain.model.ProductResponse
import sistemas.jd.gok.challenge.ui.adapters.SpotlightAdapterViewPager
import sistemas.jd.gok.challenge.ui.fragments.CashFragment
import sistemas.jd.gok.challenge.ui.fragments.ProductsFragment
import sistemas.jd.gok.challenge.utils.LoadingState
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
        initializeData()
        configureView()
        setupViewPager()
        setupObservers()
    }

    private fun initializeData() {
        viewModel.getAll()
    }

    private fun configureView() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
    }

    private fun setupObservers() {
        viewModel.products.observe(this, Observer { data ->
            binding?.viewPagerSpotligth?.adapter = SpotlightAdapterViewPager(data.spotlight, this)
            addCashFragment(data)
            addProductFragment(data)
        })

        viewModel.loadingState.observe(this, Observer {
            when(it.status) {
                LoadingState.Status.FAILED -> showScreenError()
                LoadingState.Status.RUNNING -> binding?.progressBar?.visibility = View.VISIBLE
                LoadingState.Status.SUCCESS -> binding?.progressBar?.visibility = View.GONE
            }
        })
    }

    private fun showScreenError() {
        binding?.progressBar?.visibility = View.GONE
        startActivity(Intent(this, ScreenErrorActivity::class.java))
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