package mobi.asta.imagesinfo.manager

import mobi.asta.imagesinfo.manager.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET


interface ITAService {
    @GET("users")
    fun listUsers(): Call<UserResponse>
}