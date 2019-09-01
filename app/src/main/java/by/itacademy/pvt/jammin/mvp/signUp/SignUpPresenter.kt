package by.itacademy.pvt.jammin.mvp.signUp

import android.content.Context
import android.widget.Toast
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault

class SignUpPresenter {

    private var view: SignUpView? = null
    private var context: Context? = null

    fun setContext(context: Context) {
        this.context = context
    }

    fun setView(view: SignUpView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
    }

    fun registration(email: String, password: String, name: String, instrument: String, contact: String) {
        val user = BackendlessUser()
        user.email = email
        user.password = password
        user.setProperty("name", name)
        user.setProperty("instrument", instrument)
        user.setProperty("contact", contact)
        view?.progressBarOn()
        Backendless.UserService.register(user, object : AsyncCallback<BackendlessUser> {

            override fun handleResponse(response: BackendlessUser) {
                view?.progressBarOff()
                Toast.makeText(context, "User has been registered", Toast.LENGTH_LONG).show()
            }

            override fun handleFault(fault: BackendlessFault) {
                view?.progressBarOff()
                Toast.makeText(context, fault.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}