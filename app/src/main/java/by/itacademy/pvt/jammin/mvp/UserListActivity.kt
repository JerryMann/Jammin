package by.itacademy.pvt.jammin.mvp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.entity.User
import by.itacademy.pvt.jammin.entity.UserManagerTemp
import by.itacademy.pvt.jammin.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_list_user.*
import java.util.*
import kotlin.concurrent.schedule

class UserListActivity : Activity(), RecyclerAdapter.ClickListener {

    private lateinit var listAdapter: RecyclerAdapter
    private lateinit var searchText: String
    private lateinit var recycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        recycleView = findViewById(R.id.searchListRecycler)
        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = LinearLayoutManager(this)
        listAdapter = RecyclerAdapter(UserManagerTemp.getUserList(), this)

        searchUser.addTextChangedListener(object : TextWatcher {

            private var timer = Timer()

            override fun afterTextChanged(sequence: Editable?) {
                timer.cancel()
                timer = Timer()
                timer.schedule(500) {
                    searchText = sequence.toString()
                    runOnUiThread {
                        recycleView.adapter = listAdapter
                        startSearch()
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        checkProfile.setOnClickListener {
            startActivity(Intent(this, YourProfileActivity::class.java))
        }

        logOut.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onUserClick(item: User) {
        startActivity(Intent(this, UserProfileActivity::class.java))
    }

    private fun startSearch() {
        if (searchText != "") {
            listAdapter.updateList(UserManagerTemp.findUser(searchText))
        } else {
            recycleView.adapter = null
        }
    }
}