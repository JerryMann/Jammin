package by.itacademy.pvt.jammin.mvp.yourProfile

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.net.UserRepository
import by.itacademy.pvt.jammin.net.provideUserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_your_profile.*

class YourProfileActivity : Activity(), YourProfileView {

    private val userRepository: UserRepository = provideUserRepository()

    private lateinit var presenter: YourProfilePresenter
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
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
        user = auth.currentUser!!
        Log.e("AAA", user.uid)

        presenter = YourProfilePresenter()
        presenter.setView(this)


        backToList.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showProfile() {

        userRepository.getUser(user.uid)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}