package com.greenapp.zaba37.tar.Activity

import android.content.Context
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.greenapp.zaba37.tar.R
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager


class RegisterActivity : BaseActivity() {

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

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
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
