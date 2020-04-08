package ng.com.intellifarms

data class SignUpRequest (
    val username: String,
    val password: String,
    val type: String,
    val sname: String,
    val fname: String,
    val mname: String,
    val phone: String,
    val email: String,
    val address: String,
    val nationality: String,
    val latitude: String,
    val longitude: String
)