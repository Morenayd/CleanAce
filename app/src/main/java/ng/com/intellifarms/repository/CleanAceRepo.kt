package ng.com.intellifarms.repository

import ng.com.intellifarms.model.request.SignInRequest
import ng.com.intellifarms.model.response.SignInResponse
import ng.com.intellifarms.data.source.remote.service.CleanAceService
import ng.com.intellifarms.networkUtils.GENERIC_ERROR_CODE
import ng.com.intellifarms.networkUtils.GENERIC_ERROR_MESSAGE
import ng.com.intellifarms.networkUtils.getAPIResult
import ng.com.intellifarms.networkUtils.Result
import java.lang.Exception

class CleanAceRepo(private val cleanAceService: CleanAceService) {

    suspend fun signIn(signInRequest: SignInRequest): Result<SignInResponse> {
        return try {
            getAPIResult(cleanAceService.signIn(signInRequest))
        } catch (e: Exception) {
            Result.Error(GENERIC_ERROR_CODE, GENERIC_ERROR_MESSAGE)
        }
    }
}