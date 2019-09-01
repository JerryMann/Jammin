package by.itacademy.pvt.jammin.mvp.signUp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import by.itacademy.pvt.jammin.R
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : Activity() {

    companion object {
        private const val APPID = "3DB46DD2-BE7E-A51D-FF8E-21FAF7837500"
        private const val APIKEY = "69EDE62E-D9C6-2422-FF10-65E6E641AD00"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        Backendless.initApp(this, APPID, APIKEY)

        val email = findViewById<TextView>(R.id.createEmail)
        val passwordOne = findViewById<TextView>(R.id.createPassword)
        val passwordTwo = findViewById<TextView>(R.id.confirmPassword)

        registerButton.setOnClickListener {
            if (passwordOne.text.toString() == passwordTwo.text.toString() &&
                email.text.isNotEmpty() &&
                passwordOne.text.isNotEmpty()
            ) {
                registration(
                    email.text.toString(),
                    passwordOne.text.toString()
                )
            } else {
                Toast.makeText(getContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            }
        }

        backToTitle.setOnClickListener {
            onBackPressed()
        }
    }

    private fun registration(email: String, password: String) {

        val user = BackendlessUser()
        user.email = email
        user.password = password
        user.setProperty("name", createName.text.toString())
        user.setProperty("instrument", createInstrument.text.toString())
        user.setProperty("contact", createContact.text.toString())
        //progressBar.setVisibility(View.VISIBLE)
        Backendless.UserService.register(user, object : AsyncCallback<BackendlessUser> {

            override fun handleResponse(response: BackendlessUser) {
                //progressBar.setVisibility(View.INVISIBLE)
                Toast.makeText(getContext(), "User has been registered", Toast.LENGTH_LONG).show()
                onBackPressed()
            }

            override fun handleFault(fault: BackendlessFault) {
                //progressBar.setVisibility(View.INVISIBLE)
                Toast.makeText(getContext(), fault.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getContext(): Context {
        return this
    }
}