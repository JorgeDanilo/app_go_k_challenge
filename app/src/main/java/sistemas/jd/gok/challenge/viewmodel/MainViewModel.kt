package sistemas.jd.gok.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import sistemas.jd.gok.challenge.domain.model.ProductResponse
import sistemas.jd.gok.challenge.domain.repository.ProductRepository
import sistemas.jd.gok.challenge.objects.Variables
import sistemas.jd.gok.challenge.utils.LoadingState

class MainViewModel(private val repository: ProductRepository) : BaseViewModel() {

    private val _products: MutableLiveData<ProductResponse> = MutableLiveData()
    val products: LiveData<ProductResponse> get() = _products
    val loadingState: LiveData<LoadingState> get() = _loadingState

    fun getAll() {
        viewModelScope.launch {
            if (Variables.isNetworkConnected) {
                _loadingState.value = LoadingState.LOADING
                try {
                    _products.value = repository.getAll()
                    _loadingState.value = LoadingState.LOADED
                } catch (t: Throwable) {
                    _loadingState.value = LoadingState.error(t.message)
                } finally {
                    _loadingState.value = LoadingState.LOADED
                }
            } else {
                _loadingState.value = LoadingState.error("Você está sem internet!")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}