package by.itacademy.pvt.jammin.mvp.signIn

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.mvp.signUp.SignUpActivity
import by.itacademy.pvt.jammin.mvp.userList.UserListActivity
import com.backendless.Backendless
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : Activity(), SignInView {

    companion object {
        private const val APPID = "3DB46DD2-BE7E-A51D-FF8E-21FAF7837500"
        private const val APIKEY = "69EDE62E-D9C6-2422-FF10-65E6E641AD00"
    }

    private lateinit var presenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        Backendless.initApp(this, APPID, APIKEY)

        presenter = SignInPresenter()
        presenter.setContext(this)
        presenter.setView(this)

        val email = findViewById<TextView>(R.id.emailInput)
        val password = findViewById<TextView>(R.id.passwordInput)

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInButton.setOnClickListener {
            if (email.text.isNotEmpty() &&
                password.text.isNotEmpty()
            ) {
                presenter.signIn(
                    email.text.toString(),
                    password.text.toString()
                )
                startActivity(Intent(this, UserListActivity::class.java))
            } else {
                Toast.makeText(this, "Authorisation failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun progressBarOn() {
        progressSignIn.visibility = View.VISIBLE
    }

    override fun progressBarOff() {
        progressSignIn.visibility = View.INVISIBLE
    }
}