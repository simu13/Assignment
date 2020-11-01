package com.example.assignment.friends

import android.os.Parcel
import android.os.Parcelable

data class ContentDTO(var explain : String? = null,
                      var username:String? = null,
                      var imageUrl : String? = null,
                      var profileUrl : String? = null,
                      var uid : String? = null,
                      var userId : String? = null,
                      var timestamp : Long? = null,
                      var favoriteCount : Int = 0,
                      var favorites : MutableMap<String,Boolean> = HashMap()):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readInt(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(explain)
        parcel.writeString(username)
        parcel.writeString(imageUrl)
        parcel.writeString(profileUrl)
        parcel.writeString(uid)
        parcel.writeString(userId)
        parcel.writeValue(timestamp)
        parcel.writeInt(favoriteCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContentDTO> {
        override fun createFromParcel(parcel: Parcel): ContentDTO {
            return ContentDTO(parcel)
        }

        override fun newArray(size: Int): Array<ContentDTO?> {
            return arrayOfNulls(size)
        }
    }
}