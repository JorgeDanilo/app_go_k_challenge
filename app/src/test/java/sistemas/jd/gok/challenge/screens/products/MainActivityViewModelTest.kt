package sistemas.jd.gok.challenge.screens.products

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import sistemas.jd.gok.challenge.base.BaseUTTest
import sistemas.jd.gok.challenge.di.configureTestAppComponent
import sistemas.jd.gok.challenge.viewmodel.MainViewModel

@RunWith(JUnit4::class)
class MainActivityViewModelTest : BaseUTTest() {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var mMainViewModel: MainViewModel

    val mDispatcher = Dispatchers.Unconfined

    val mUrl = "https://swapi.co/api/people/?page=2"

    @Before
    fun start() {
        super.setUp()
        MockKAnnotations.init(this)
        startKoin { modules(configureTestAppComponent(getMockWebServerUrl())) }
    }

    @Test
    fun test_load_products_view_model_data_populates_expected_value() {
        
    }
}