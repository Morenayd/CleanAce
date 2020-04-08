package ng.com.intellifarms.model.request

data class SignInRequest(
    val type: String,
    val username: String,
    val password: String
)
