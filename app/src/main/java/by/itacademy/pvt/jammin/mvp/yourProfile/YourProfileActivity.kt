package by.itacademy.pvt.jammin.mvp.yourProfile

import android.app.Activity
import android.os.Bundle
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.entity.User
import kotlinx.android.synthetic.main.activity_your_profile.*

class YourProfileActivity : Activity(), YourProfileView {

    private lateinit var presenter: YourProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_profile)

        presenter = YourProfilePresenter()
        presenter.setView(this)



        backToList.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showProfile(user: User?) {
        //TODO показ данных залогиневшегося юзера
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}