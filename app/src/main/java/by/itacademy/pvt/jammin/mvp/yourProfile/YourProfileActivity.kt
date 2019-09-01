package by.itacademy.pvt.jammin.mvp.yourProfile

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import by.itacademy.pvt.jammin.R
import com.backendless.Backendless
import kotlinx.android.synthetic.main.activity_your_profile.*

class YourProfileActivity : Activity(), YourProfileView {

    private lateinit var presenter: YourProfilePresenter
    private lateinit var tvImageUrl: TextView
    private lateinit var tvName: TextView
    private lateinit var tvInstrument: TextView
    private lateinit var tvContact: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_profile)

        tvImageUrl = findViewById(R.id.changeAvatar)
        tvName = findViewById(R.id.profileName)
        tvInstrument = findViewById(R.id.profileInstrument)
        tvContact = findViewById(R.id.profileContact)

        val bUser = Backendless.UserService.CurrentUser()

        presenter = YourProfilePresenter()
        presenter.setView(this)
        presenter.setContext(this)
        presenter.loadUser(bUser.objectId)

        backToList.setOnClickListener {
            onBackPressed()
        }

        saveButton.setOnClickListener {
            presenter.saveChanges(
                contact = tvContact.text.toString(),
                id = bUser.objectId,
                instrument = tvInstrument.text.toString(),
                name = tvName.text.toString(),
                imageUrl = tvImageUrl.text.toString()
            )
        }
    }

    override fun showProfile(imageUrl: String?, name: String, instrument: String, contact: String) {
        tvImageUrl.text = imageUrl
        tvName.text = name
        tvInstrument.text = instrument
        tvContact.text = contact
    }

    override fun progressBarOn() {
        progressYourProfile.visibility = View.VISIBLE
    }

    override fun progressBarOff() {
        progressYourProfile.visibility = View.INVISIBLE
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}