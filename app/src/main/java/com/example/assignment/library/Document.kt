package com.example.assignment.library

import android.os.Parcel
import android.os.Parcelable

data class Document(
    val id:String="",
    val name:String=""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Document> = object : Parcelable.Creator<Document> {
            override fun createFromParcel(source: Parcel): Document = Document(source)
            override fun newArray(size: Int): Array<Document?> = arrayOfNulls(size)
        }
    }
}