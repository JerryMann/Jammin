package by.itacademy.pvt.jammin.mvp.signUp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import by.itacademy.pvt.jammin.R
import com.backendless.Backendless
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : Activity(), SignUpView {

    companion object {
        private const val APPID = "3DB46DD2-BE7E-A51D-FF8E-21FAF7837500"
        private const val APIKEY = "69EDE62E-D9C6-2422-FF10-65E6E641AD00"
    }

    private lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        Backendless.initApp(this, APPID, APIKEY)

        presenter = SignUpPresenter()
        presenter.setContext(this)
        presenter.setView(this)

        val email = findViewById<EditText>(R.id.createEmail)
        val passwordOne = findViewById<EditText>(R.id.createPassword)
        val passwordTwo = findViewById<EditText>(R.id.confirmPassword)
        val name = findViewById<EditText>(R.id.createName)
        val instrument = findViewById<EditText>(R.id.createInstrument)
        val contact = findViewById<EditText>(R.id.createContact)

        registerButton.setOnClickListener {
            if (passwordOne.text.toString() == passwordTwo.text.toString() &&
                email.text.isNotEmpty() &&
                passwordOne.text.isNotEmpty()
            ) {
                presenter.registration(
                    email = email.text.toString(),
                    password =  passwordOne.text.toString(),
                    name = name.text.toString(),
                    instrument = instrument.text.toString(),
                    contact = contact.text.toString()
                )
            } else {
                Toast.makeText(getContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            }
        }

        backToTitle.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun progressBarOn() {
        progressSignUp.visibility = View.VISIBLE
    }

    override fun progressBarOff() {
        progressSignUp.visibility = View.INVISIBLE
    }


    private fun getContext(): Context {
        return this
    }
}