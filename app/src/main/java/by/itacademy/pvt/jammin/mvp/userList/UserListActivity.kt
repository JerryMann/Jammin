package by.itacademy.pvt.jammin.mvp.userList

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
import by.itacademy.pvt.jammin.mvp.userProfile.UserProfileActivity
import by.itacademy.pvt.jammin.mvp.yourProfile.YourProfileActivity
import by.itacademy.pvt.jammin.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_list_user.*
import java.util.*
import kotlin.concurrent.schedule

class UserListActivity : Activity(), UserListView, RecyclerAdapter.ClickListener {

    private lateinit var recycleView: RecyclerView
    private lateinit var presenter: UserListPresenter
    private var searchText: String = ""
    private var listAdapter = RecyclerAdapter(emptyList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        presenter = UserListPresenter()
        presenter.setContext(this)
        presenter.setView(this)

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

        savedListButton.setOnClickListener {

        }
    }

    override fun onUserClick(item: User) {
        startActivity(UserProfileActivity.getIntent(this, item.id))
    }

    override fun showList(list: List<User>) {
        startSearch()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    private fun startSearch() {
   // listAdapter.updateList(presenter.getAllUsers())
        if (searchText != "") {
            listAdapter.updateList(UserManagerTemp.findUser(searchText))
        } else {
            recycleView.adapter = null
        }
    }
}