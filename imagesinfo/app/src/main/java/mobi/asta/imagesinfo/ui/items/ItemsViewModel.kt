package mobi.asta.imagesinfo.ui.items

import android.arch.lifecycle.ViewModel
import mobi.asta.imagesinfo.manager.ITAInternetManager
import mobi.asta.imagesinfo.manager.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ItemsInterface {
    fun loadFinished(items: List<UserData>)
    fun loadError(value: String)
}

class ItemsViewModel : ViewModel() {

    val internetManager: ITAInternetManager = ITAInternetManager.instance
    var viewModel: ItemsInterface? = null


    fun initLoad() {
        internetManager.listUsers().enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                viewModel?.loadError(t.message!!)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val items = ArrayList<UserData>()

                response.body()?.dataUser?.forEach {
                    val ud = UserData()
                    ud.avatar = it.avatar
                    ud.id = it.id
                    ud.firstName = it.firstName
                    ud.lastName = it.lastName
                    items.add(ud)
                }

                viewModel?.loadFinished(items)
            }
        })
    }

}