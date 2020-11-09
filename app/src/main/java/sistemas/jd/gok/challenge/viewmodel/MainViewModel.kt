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

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(context = Main + viewModelJob)
    private val _products: MutableLiveData<ProductResponse> = MutableLiveData()
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    val products: LiveData<ProductResponse> get() = _products
    val loading: LiveData<Boolean> get() = _loading
    val error: LiveData<Throwable> get() = _error

    fun getAll() {
        viewModelScope.launch {
            _loading.value = true
            try {
                _products.value = repository.getAll()
                _loading.value = false
            } catch (t: Throwable) {
                _error.value = t
            } finally {
                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}