package by.itacademy.pvt.jammin.mvp

import android.app.Activity
import android.os.Bundle
import by.itacademy.pvt.jammin.R
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        backToList.setOnClickListener {
            onBackPressed()
        }
    }
}