package com.greenapp.zaba37.tar.Activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.content.Context
import android.os.PersistableBundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.greenapp.zaba37.tar.R

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    val mAuth = FirebaseAuth.getInstance()

    var emailTextLayout: TextInputLayout? = null
    var passwordTextLayout: TextInputLayout? = null
    var emailField: TextInputEditText? = null
    var passwordField: TextInputEditText? = null
    var registerButton: Button? = null
    var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailField = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)
        registerButton = findViewById(R.id.registerButton)
        progress = findViewById(R.id.progressBar2)
        emailTextLayout = findViewById(R.id.textInputLayout)
        passwordTextLayout = findViewById(R.id.textInputLayout2)
    }

    fun registerAction(view: View) {
        val emailF = emailField.let { it } ?: return
        val passwordF = passwordField.let { it } ?: return

        val email = emailF.text.toString()
        val password = passwordF.text.toString()

        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        progress!!.visibility = View.VISIBLE

        emailField!!.visibility = View.INVISIBLE
        passwordField!!.visibility = View.INVISIBLE
        registerButton!!.visibility = View.INVISIBLE
        emailTextLayout!!.visibility = View.INVISIBLE
        passwordTextLayout!!.visibility = View.INVISIBLE

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, it.exception!!.message ?: "", Toast.LENGTH_SHORT).show()
            }

            progress!!.visibility = View.INVISIBLE

            emailField!!.visibility = View.VISIBLE
            passwordField!!.visibility = View.VISIBLE
            registerButton!!.visibility = View.VISIBLE
            emailTextLayout!!.visibility = View.VISIBLE
            passwordTextLayout!!.visibility = View.VISIBLE
        }
    }
}
