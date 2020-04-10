package ng.com.intellifarms.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ng.com.intellifarms.model.request.SignInRequest


enum class NavigationFlow { c, d }

class SignInViewModel: ViewModel() {

    private val _navigationFlow = MutableLiveData<NavigationFlow>()
    val navigationFlow: LiveData<NavigationFlow>
        get() = _navigationFlow

    init {
        Log.i("SignInViewModel", " created!")
    }

    fun signIn(signInRequest: SignInRequest) {

    }


}