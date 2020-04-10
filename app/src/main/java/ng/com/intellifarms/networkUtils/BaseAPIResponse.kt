package ng.com.intellifarms.networkUtils

import com.google.gson.annotations.SerializedName

class BaseAPIResponse<T> {

    @SerializedName("status")
    lateinit var status: String

    @SerializedName("data")
    var data: T? = null
}