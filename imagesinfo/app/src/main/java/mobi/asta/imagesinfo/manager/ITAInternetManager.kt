package mobi.asta.imagesinfo.manager

import mobi.asta.imagesinfo.manager.response.UserResponse
import retrofit2.Call
import retrofit2.Retrofit


class ITAInternetManager : ITAService {

    var service: ITAService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        service = retrofit.create<ITAService>(ITAService::class.java)
    }

    override fun listUsers(): Call<List<UserResponse>> {
        return service.listUsers()
    }

}
