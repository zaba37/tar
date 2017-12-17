package com.greenapp.zaba37.tar.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.google.firebase.FirebaseApp
import com.greenapp.zaba37.tar.Fragment.RegisterFragment
import com.greenapp.zaba37.tar.Fragment.StartAppFragment
import com.greenapp.zaba37.tar.R


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loginAction(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun registerAction(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}