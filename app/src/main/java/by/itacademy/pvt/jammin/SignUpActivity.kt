package by.itacademy.pvt.jammin

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        backToTitle.setOnClickListener {
            onBackPressed()
        }
    }
}