package by.itacademy.pvt.jammin.mvp.userList

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.entity.User
import by.itacademy.pvt.jammin.mvp.userProfile.UserProfileActivity
import by.itacademy.pvt.jammin.mvp.yourProfile.YourProfileActivity
import by.itacademy.pvt.jammin.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_list_user.*

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
        recycleView.adapter = listAdapter

        startSearch.setOnClickListener {
            loadSearchingList()
            listAdapter.notifyDataSetChanged()
        }

        checkProfile.setOnClickListener {
            startActivity(Intent(this, YourProfileActivity::class.java))
        }

        logOut.setOnClickListener {
            onBackPressed()
        }

        savedListButton.setOnClickListener {
            //TODO загрузить сохраенных юзеров из бд
        }
    }

    override fun onUserClick(item: User) {
        startActivity(UserProfileActivity.getIntent(this, item.id))
    }

    override fun progressBarOn() {
        progressList.visibility = View.VISIBLE
    }

    override fun progressBarOff() {
        progressList.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    private fun loadSearchingList() {
        searchText = searchUser.text.toString()
        listAdapter = RecyclerAdapter(presenter.getUsersByInstrument(searchText), this)
        recycleView.adapter = listAdapter
    }
}