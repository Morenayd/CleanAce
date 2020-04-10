package ng.com.intellifarms.networkUtils

import android.util.Log
import org.json.JSONObject
import retrofit2.Response

const val GENERIC_ERROR_MESSAGE = "We are unable to proceed due to network failure. Please try again"
const val GENERIC_ERROR_CODE = "-1"
const val TAG = "APIUtils"

fun <T : Any> getAPIResult(response: Response<BaseAPIResponse<T>>): Result<T> {
    if (response.isSuccessful) {
        val body = response.body()
        if (body?.data != null) {
            return Result.Success(body.data!!)
        }
    }

    return Result.Error("${response.code()}", response.message())
}

fun getErrorMessage(errorBody: String): String {
    return try {
        val errorBodyJsonObject = JSONObject(errorBody)
        errorBodyJsonObject.getString("message")
    } catch (e: Exception) {
        Log.e(TAG, e.toString())
        GENERIC_ERROR_MESSAGE
    }
}

fun getErrorCode(errorBody: String?): String {
    return try {
        val errorBodyJsonObject = JSONObject(errorBody)
        errorBodyJsonObject.getString("code")
    } catch (e: Exception) {
        Log.e(TAG, e.toString())
        GENERIC_ERROR_CODE
    }
}
