package sistemas.jd.gok.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import sistemas.jd.gok.challenge.utils.LoadingState

open class BaseViewModel(): ViewModel() {
    protected val viewModelJob = SupervisorJob()
    protected val viewModelScope = CoroutineScope(context = Dispatchers.Main + viewModelJob)
    protected val _loadingState = MutableLiveData<LoadingState>()
}