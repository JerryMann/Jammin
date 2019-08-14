package by.itacademy.pvt.jammin.utils

import android.widget.ImageView
import by.itacademy.pvt.jammin.R
import by.itacademy.pvt.jammin.utils.transform.Circular
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun loadImage(url: String, imageView: ImageView) {
    Picasso.get()
        .load(url)
        .error(R.drawable.key)
        .into(imageView, object : Callback {
            override fun onSuccess() {
                return
            }

            override fun onError(e: Exception?) {
            }
        })
}

fun loadCircularImage(url: String, imageView: ImageView) {
    Picasso.get()
        .load(url)
        .error(R.drawable.key)
        .transform(Circular())
        .into(imageView, object : Callback {
            override fun onSuccess() {
                return
            }

            override fun onError(e: Exception?) {
            }
        })
}