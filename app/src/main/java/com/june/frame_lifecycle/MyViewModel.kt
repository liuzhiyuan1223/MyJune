package com.june.frame_lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    val myLiveData : MutableLiveData<DataModelLife> = MutableLiveData()

    //更新数据
    fun updateMyLiveData(dataModel: DataModelLife){
        myLiveData.postValue(dataModel)
    }
}