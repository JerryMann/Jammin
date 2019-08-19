package by.itacademy.pvt.jammin.mvp.yourProfile

class YourProfilePresenter {

    private var view: YourProfileView? = null

    fun setView(view: YourProfileView) {
        this.view = view
    }

    fun onViewDestroyed() {
        this.view = null
    }

    fun saveChanges(){
        //TODO логика сохранения данных залогиневшегося юзера
    }
}