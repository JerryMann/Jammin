package by.itacademy.pvt.jammin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import by.itacademy.pvt.jammin.mvp.userList.UserListActivity
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import kotlinx.android.synthetic.main.activity_sign_in.*

private const val APPID = "3DB46DD2-BE7E-A51D-FF8E-21FAF7837500"
private const val APIKEY = "69EDE62E-D9C6-2422-FF10-65E6E641AD00"

class SignInActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val login = findViewById<TextView>(R.id.emailInput)
        val password = findViewById<TextView>(R.id.passwordInput)

        Backendless.initApp(this, APPID, APIKEY)

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInButton.setOnClickListener {
            startActivity(Intent(this, UserListActivity::class.java))
        }
    }

    private fun getContext(): Context {
        return this
    }
}





//if (login.text != null && password.text != null) {
//
//                Backendless.UserService.login(
//                    login.text.toString(),
//                    password.text.toString(),
//                    object : AsyncCallback<BackendlessUser> {
//                        override fun handleResponse(response: BackendlessUser) {
//                            Toast.makeText(getContext(), "User has been logged in", Toast.LENGTH_LONG).show()
//                            startActivity(Intent(getContext(), UserListActivity::class.java))
//                        }
//
//                        override fun handleFault(fault: BackendlessFault) {
//                            Toast.makeText(getContext(), fault.message, Toast.LENGTH_LONG).show()
//                        }
//                    })
//            } else {
//                Toast.makeText(getContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show()
//            }