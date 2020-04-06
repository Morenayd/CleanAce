package ng.com.intellifarms

data class SignInRequest(
    val type: String,
    val username: String,
    val password: String
)
