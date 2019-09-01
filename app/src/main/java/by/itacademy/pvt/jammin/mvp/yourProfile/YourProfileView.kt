package by.itacademy.pvt.jammin.mvp.yourProfile

interface YourProfileView {
    fun showProfile(imageUrl: String?, name: String, instrument: String, contact: String)
    fun progressBarOn()
    fun progressBarOff()
}