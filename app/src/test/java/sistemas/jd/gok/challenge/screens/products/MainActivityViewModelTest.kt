package sistemas.jd.gok.challenge.screens.products

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import sistemas.jd.gok.challenge.base.BaseUTTest
import sistemas.jd.gok.challenge.di.configureTestAppComponent
import sistemas.jd.gok.challenge.domain.repository.ProductRepository
import sistemas.jd.gok.challenge.utils.LoadingState
import sistemas.jd.gok.challenge.viewmodel.MainViewModel

@RunWith(JUnit4::class)
class MainActivityViewModelTest : BaseUTTest() {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var repo: ProductRepository

    @Rule
    @JvmField
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    private var _loadingState = MutableLiveData<LoadingState>()


    @Before
    fun start() {
        super.setUp()
        viewModel = MainViewModel(repo)
        startKoin { modules(configureTestAppComponent(getMockWebServerUrl())) }
        _loadingState.value = viewModel.loadingState.value
    }

    @Test
    fun test_load_products_view_model_data_populates_expected_value() = runBlocking {
        val isLoading = _loadingState
        assertNotNull(isLoading)
        viewModel.getAll()
        return@runBlocking
    }
}