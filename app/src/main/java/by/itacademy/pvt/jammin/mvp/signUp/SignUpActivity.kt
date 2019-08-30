package by.itacademy.pvt.jammin.mvp.signUp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import by.itacademy.pvt.jammin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : Activity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("Users")

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
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    val uProfile = HashMap<Any, String>()
                    uProfile["name"] = createName.text.toString()
                    uProfile["uid"] = uid
                    uProfile["instrument"] = createInstrument.text.toString()
                    uProfile["contact"] = createContact.text.toString()

                    dbRef.child(uid).setValue(uProfile)

                    Toast.makeText(getContext(), "Регистрация успешна", Toast.LENGTH_SHORT).show()
                    onBackPressed()
                } else
                    Toast.makeText(getContext(), "Регистрация провалена", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getContext(): Context {
        return this
    }
}