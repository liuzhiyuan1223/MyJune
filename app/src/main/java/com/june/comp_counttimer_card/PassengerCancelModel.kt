package com.june.comp_counttimer_card

import android.os.Parcel
import android.os.Parcelable

class PassengerCancelModel() : Parcelable {

    var oid: String? = null

    var travelId: String? = null

    /**
     * 0: 取消详情
     * 1: 订单详情
     */
    var action = 0

    var content: String? = null

    var amount = 0.0

    var subTitle: String? = null

    var phoneProtected = 0

    var phoneExpired = 0

    fun isValid(): Boolean {
        return oid != null
    }

    constructor(parcel: Parcel) : this() {
        oid = parcel.readString()
        travelId = parcel.readString()
        action = parcel.readInt()
        content = parcel.readString()
        amount = parcel.readDouble()
        subTitle = parcel.readString()
        phoneProtected = parcel.readInt()
        phoneExpired = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(oid)
        parcel.writeString(travelId)
        parcel.writeInt(action)
        parcel.writeString(content)
        parcel.writeDouble(amount)
        parcel.writeString(subTitle)
        parcel.writeInt(phoneProtected)
        parcel.writeInt(phoneExpired)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PassengerCancelModel> {
        override fun createFromParcel(parcel: Parcel): PassengerCancelModel {
            return PassengerCancelModel(parcel)
        }

        override fun newArray(size: Int): Array<PassengerCancelModel?> {
            return arrayOfNulls(size)
        }
    }

}