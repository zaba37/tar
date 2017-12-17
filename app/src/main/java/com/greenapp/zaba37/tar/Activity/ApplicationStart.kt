package com.greenapp.zaba37.tar.Activity

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.FirebaseApp

/**
 * Created by zaba37 on 17/12/2017.
 */
class ApplicationStart() : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }

}