package by.itacademy.pvt.jammin.mvp.signIn

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.mvp.signUp.SignUpActivity
import by.itacademy.pvt.jammin.mvp.userList.UserListActivity
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : Activity() {

    companion object {
        private const val APPID = "3DB46DD2-BE7E-A51D-FF8E-21FAF7837500"
        private const val APIKEY = "69EDE62E-D9C6-2422-FF10-65E6E641AD00"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        Backendless.initApp(this, APPID, APIKEY)

        val email = findViewById<TextView>(R.id.emailInput)
        val password = findViewById<TextView>(R.id.passwordInput)

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInButton.setOnClickListener {
            if (email.text.isNotEmpty() &&
            password.text.isNotEmpty()) {
                signIn(
                    email.text.toString(),
                    password.text.toString()
                )
            } else {
                Toast.makeText(this, "Authorisation failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signIn(email: String, password: String) {

        Backendless.UserService.login(email, password,
            object : AsyncCallback<BackendlessUser> {
                override fun handleResponse(response: BackendlessUser) {
                    Toast.makeText(getContext(), "User has been logged in", Toast.LENGTH_LONG).show()
                    startActivity(Intent(getContext(), UserListActivity::class.java))
                }

                override fun handleFault(fault: BackendlessFault) {
                    Toast.makeText(getContext(), fault.message, Toast.LENGTH_LONG).show()
                }
            })
    }

    private fun getContext(): Context {
        return this
    }
}