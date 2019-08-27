package by.itacademy.pvt.jammin.mvp.yourProfile

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import by.itacademy.pvt.jammin.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_your_profile.*

class YourProfileActivity : Activity(), YourProfileView {

    private lateinit var presenter: YourProfilePresenter
    private lateinit var auth: FirebaseAuth
    private lateinit var fbUser: FirebaseUser
    private lateinit var dbRef: DatabaseReference

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

        auth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("Users")
        fbUser = auth.currentUser!!
        Log.e("AAA", fbUser.uid)

        presenter = YourProfilePresenter()
        presenter.setView(this)
        presenter.loadUser(fbUser.uid)

        backToList.setOnClickListener {
            onBackPressed()
        }

        saveButton.setOnClickListener {
            presenter.saveChanges(
                contact = tvContact.text.toString(),
                id = fbUser.uid,
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

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}