package com.june.compo_recyclerview

class DataModel {

    var name : String = ""
    var clickCallBack : InterfaceClickCallback? = null

    fun setClickCallback(clickCallBack : InterfaceClickCallback?){
        this.clickCallBack = clickCallBack
    }
}