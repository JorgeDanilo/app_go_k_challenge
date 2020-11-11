package sistemas.jd.gok.challenge.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import sistemas.jd.gok.challenge.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import sistemas.jd.gok.challenge.ui.adapters.SpotlightAdapter
import sistemas.jd.gok.challenge.utils.LinePagerIndicatorDecoration
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
        observerSpotlight()
    }

    private fun configureView() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
    }

    private fun observerSpotlight() {
        binding?.rvSpotlight?.addItemDecoration(LinePagerIndicatorDecoration())
        viewModel.products.observe(this, Observer { data ->
            binding?.rvSpotlight?.adapter = SpotlightAdapter(data.spotlight)
        })
    }
}