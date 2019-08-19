package by.itacademy.pvt.jammin.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.entity.User

class RecyclerAdapter(
    private var items: List<User>,
    private val listener: ClickListener
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        val holder = ViewHolder(view)

        holder.itemView.setOnClickListener {
            listener.onUserClick(items[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(items: List<User>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onUserClick(item: User)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageUser = itemView.findViewById<ImageView>(R.id.userAvatar)
    private val nameUser = itemView.findViewById<TextView>(R.id.userName)
    private val instrumentUser = itemView.findViewById<TextView>(R.id.userInstrument)

    fun bind(item: User) {
        loadCircularImage(item.imageUrl!!, imageUser)
        nameUser.text = item.name
        instrumentUser.text = item.instrument
    }
}