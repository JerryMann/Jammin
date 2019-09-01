package by.itacademy.pvt.jammin.mvp.signIn

import android.content.Context
import android.widget.Toast
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault

class SignInPresenter {

    private var view: SignInView? = null
    private var context: Context? = null

    fun setContext(context: Context) {
        this.context = context
    }

    fun setView(view: SignInView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
    }

    fun signIn(email: String, password: String) {
        view?.progressBarOn()
        Backendless.UserService.login(email, password,
            object : AsyncCallback<BackendlessUser> {
                override fun handleResponse(response: BackendlessUser) {
                    view?.progressBarOff()
                    Toast.makeText(context, "User has been logged in", Toast.LENGTH_LONG).show()
                }

                override fun handleFault(fault: BackendlessFault) {
                    view?.progressBarOff()
                    Toast.makeText(context, fault.message, Toast.LENGTH_LONG).show()
                }
            })
    }
}