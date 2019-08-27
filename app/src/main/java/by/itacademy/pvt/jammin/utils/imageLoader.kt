package by.itacademy.pvt.jammin.utils

import android.widget.ImageView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.utils.transform.Circular
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun loadImage(url: String, imageView: ImageView) {
    Picasso.get()
        .load(url)
        .into(imageView, object : Callback {
            override fun onSuccess() {
                return
            }

            override fun onError(e: Exception?) {
                Picasso.get()
                    .load(R.drawable.key)
                    .into(imageView)
            }
        })
}

fun loadCircularImage(url: String?, imageView: ImageView) {
    Picasso.get()
        .load(url)
        .transform(Circular())
        .into(imageView, object : Callback {
            override fun onSuccess() {
                return
            }

            override fun onError(e: Exception?) {
                Picasso.get()
                    .load(R.drawable.key)
                    .transform(Circular())
                    .into(imageView)
            }
        })
}