package mobi.asta.imagesinfo.manager

import mobi.asta.imagesinfo.manager.response.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ITAInternetManager private constructor() : ITAService {

    private var service: ITAService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<ITAService>(ITAService::class.java)
    }

    private object Holder {
        val INSTANCE = ITAInternetManager()
    }

    companion object {
        val instance: ITAInternetManager by lazy { Holder.INSTANCE }
    }

    override fun listUsers(): Call<UserResponse> {
        return service.listUsers()
    }

}
