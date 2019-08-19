package by.itacademy.pvt.jammin

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name = findViewById<TextView>(R.id.createName)
        val email = findViewById<TextView>(R.id.createEmail)
        val passwordOne = findViewById<TextView>(R.id.createPassword)
        val passwordTwo = findViewById<TextView>(R.id.confirmPassword)

        registerButton.setOnClickListener {

        }

        backToTitle.setOnClickListener {
            onBackPressed()
        }
    }
}