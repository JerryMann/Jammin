package by.itacademy.pvt.jammin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import by.itacademy.pvt.jammin.mvp.userList.UserListActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : Activity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val email = findViewById<TextView>(R.id.emailInput)
        val password = findViewById<TextView>(R.id.passwordInput)

        auth = FirebaseAuth.getInstance()

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
                Toast.makeText(this, "Aвторизация провалена", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
            this
        ) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Aвторизация успешна", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, UserListActivity::class.java))
            } else
                Toast.makeText(this, "Aвторизация провалена", Toast.LENGTH_SHORT).show()
        }
    }
}