package sistemas.jd.gok.challenge.ui.activities

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.ui.adapters.SpotlightAdapterViewPager
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
        observerSpotlight()
    }

    private fun configureView() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
    }

    private fun observerSpotlight() {
        viewModel.products.observe(this, Observer { data ->
            binding?.viewPagerSpotligth?.adapter = SpotlightAdapterViewPager(data.spotlight, this)
        })
    }

    private fun setupViewPager() {
        binding?.viewPagerSpotligth?.pageMargin = -60
        binding?.viewPagerSpotligth?.isHorizontalFadingEdgeEnabled = true
        binding?.viewPagerSpotligth?.setFadingEdgeLength(40)
    }
}