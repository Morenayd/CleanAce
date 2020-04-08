package ng.com.intellifarms.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ng.com.intellifarms.SignInRequest
import ng.com.intellifarms.base.BaseViewModel
import ng.com.intellifarms.service.networkUtils.Result
import ng.com.intellifarms.service.networkUtils.LoadingStatus


enum class NavigationFlow { c, d }

class SignInViewModel: BaseViewModel() {

    private val _navigationFlow = MutableLiveData<NavigationFlow>()
    val navigationFlow: LiveData<NavigationFlow>
        get() = _navigationFlow

    init {
    }

    fun signIn(signInRequest: SignInRequest): Result<*> {
        val result = signIn(signInRequest)
        viewModelScope.launch {
            _loadingStatus.value = LoadingStatus.Loading("Loading, Please wait...")
            when (result) {
                is Result.Success<*> -> {
                    Log.i("SignInView Model", "Sign in successful")
                }
                is Result.Error -> _loadingStatus.value =
                    LoadingStatus.Error(result.errorCode, result.errorMessage)
            }
        }
        return result
    }

    override fun addAllLiveDataToObservablesList() {

    }

    override fun cleanUpObservables() {
    }
}