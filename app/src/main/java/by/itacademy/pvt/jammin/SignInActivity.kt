package by.itacademy.pvt.jammin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import by.itacademy.pvt.jammin.mvp.UserListActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        signInButton.setOnClickListener {
            startActivity(Intent(this, UserListActivity::class.java))
        }
    }
}
