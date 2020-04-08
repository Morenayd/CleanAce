package ng.com.intellifarms.repository

import ng.com.intellifarms.model.request.SignInRequest
import ng.com.intellifarms.model.response.SignInResponse
import ng.com.intellifarms.data.source.remote.service.CleanAceService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CleanAceRepo(private val cleanAceService: CleanAceService) {

    fun signIn(signInRequest: SignInRequest, callback: (SignInResponse?) -> Result<*>) {
        val signInCall = cleanAceService.signIn(signInRequest)
        signInCall.enqueue(object: Callback<SignInResponse> {
            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                callback(null)
            }

            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                val body = response?.body()
                callback(body)
            }
        })
    }

}