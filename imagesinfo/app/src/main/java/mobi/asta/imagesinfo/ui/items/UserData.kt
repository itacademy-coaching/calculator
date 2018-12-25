package mobi.asta.imagesinfo.ui.items

import android.os.Parcel
import android.os.Parcelable

class UserData(
    var avatar: String = "",
    var firstName: String = "",
    var id: Int = 0,
    var lastName: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(avatar)
        writeString(firstName)
        writeInt(id)
        writeString(lastName)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<UserData> = object : Parcelable.Creator<UserData> {
            override fun createFromParcel(source: Parcel): UserData = UserData(source)
            override fun newArray(size: Int): Array<UserData?> = arrayOfNulls(size)
        }
    }
}