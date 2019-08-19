package by.itacademy.pvt.jammin.mvp.userProfile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.entity.User
import by.itacademy.pvt.jammin.entity.UserManagerTemp
import by.itacademy.pvt.jammin.utils.loadCircularImage
import kotlinx.android.synthetic.main.activity_user_profile.*

private const val ITEM_ID = "ITEM_ID"

class UserProfileActivity : Activity(), UserProfileView {

    companion object {
        fun getIntent(context: Context, id: String): Intent {
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra(ITEM_ID, id)
            return intent
        }
    }

    private lateinit var presenter: UserProfilePresenter
    private lateinit var avatarImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val itemId = intent.getStringExtra(ITEM_ID)
        val user = UserManagerTemp.getUser(itemId!!)
        avatarImageView = findViewById(R.id.profileAvatar)

        presenter = UserProfilePresenter()
        presenter.setView(this)

        if (user != null) {
            presenter.loadUserById(itemId)
        } else {
            onBackPressed()
        }

        backToList.setOnClickListener {
            onBackPressed()
        }

        saveButton.setOnClickListener {
            presenter.saveUserInYourList()
        }
    }

    override fun showUser(user: User?) {
        if (user != null) {
            loadCircularImage(user.imageUrl, avatarImageView)
            profileName.text = user.name
            profileInstrument.text = user.instrument
            profileContact.text = user.contact
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}