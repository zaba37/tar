package com.greenapp.zaba37.tar.Activity

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
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)

        val root = findViewById<FrameLayout>(R.id.rootLoginLayout)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.rootLoginLayout, StartAppFragment.newInstance(), "startAppFragment")
                .commit()
    }

    fun loginAction(view: View) {
//        val mAuth = FirebaseAuth.getInstance()
//
//        mAuth.createUserWithEmailAndPassword("zaba37@gmail.com", "123123123")
//                .addOnCompleteListener(this) { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d("asd", "createUserWithEmail:success")
//                        val user = mAuth.currentUser
//                        //updateUI(user)
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w("asdasd", "createUserWithEmail:failure", task.exception)
//                        Toast.makeText(this@MainActivity, "Authentication failed.",
//                                Toast.LENGTH_SHORT).show()
//                    }
//
//                    // ...
//                }
    }

    fun registerAction(view: View) {
        supportFragmentManager
                .beginTransaction().replace(R.id.rootLoginLayout, RegisterFragment.newInstance()).commit()
    }

//    override fun onFragmentInteraction(uri: Uri) {
//
//    }
}
