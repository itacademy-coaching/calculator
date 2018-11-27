package mobi.asta.imagesinfo.manager.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    var `data`: List<Data> = listOf(),
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("per_page")
    var perPage: Int = 0,
    @SerializedName("total")
    var total: Int = 0,
    @SerializedName("total_pages")
    var totalPages: Int = 0
) {
    data class Data(
        @SerializedName("avatar")
        var avatar: String = "",
        @SerializedName("first_name")
        var firstName: String = "",
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("last_name")
        var lastName: String = ""
    )
}