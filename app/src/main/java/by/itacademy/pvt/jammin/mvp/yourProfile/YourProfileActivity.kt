package by.itacademy.pvt.jammin.mvp.yourProfile

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.utils.loadImage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_your_profile.*

class YourProfileActivity : Activity(), YourProfileView {

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

        presenter = YourProfilePresenter()
        presenter.setView(this)

//        val query = dbRef.child("email").equalTo(user.email)
//        query.addValueEventListener(object: ValueEventListener{
//            override fun onCancelled(p0: DatabaseError) {
//                
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//                for (ds in p0.children) {
//                    tvName.text = ""+ds.child("name").value
//                    tvInstrument.text = ""+ds.child("instrument").value
//                    tvContact.text = ""+ds.child("contact").value
//                    loadImage(tvImageUrl.text.toString(), profileAvatar)
//                }
//            }
//        })

        backToList.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showProfile() {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }
}