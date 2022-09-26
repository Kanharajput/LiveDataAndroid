package com.example.livedatacomponent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* LiveData is a class which is just used to store data
   it is lifecycle aware and it automatically update the data
   in ui if the data changed.
   There are two classes one is LiveData whose data can't be changed and
   one is MutableLiveData which can be changed
   These classes only update the data of active observers
* */
/* Basically both LiveData and MutableLiveData are connect but MutableLiveData
*  can be changed by outside classes then we set it to private
*  And LiveData is not change by outsiders so we set it public
*  But LiveData is actually getting the from MutableLiveData
*  and we set our Obsever to LiveData as it is public*/


public class MainViewModel extends ViewModel {
    // declared a LiveData
    // access specifier is public because it can't be modify
    // this is the object
    private MutableLiveData<String> myNameData = new MutableLiveData<String>("kanha tomar");

    // getting the data from MutableLiveData
    public LiveData<String> myName = myNameData;

    // update the MutableLiveData
    // data can come from server or by users or from other things
    // but we should write functions which operate on the data in a same body
    // so to update MutableLiveData function should be written over here
    public void updateMutableLiveData(String data) {
        // using setValue to change the myName value
        myNameData.setValue(data);
    }
}
