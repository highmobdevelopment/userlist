package erevacation.com.userlist.ui.homescreen

import erevacation.com.userlist.basic.arhitecture.ViperContract

interface HomeContract {

    interface HomeView : ViperContract.View<HomePresenter> {

    }

    interface HomePresenter : ViperContract.Presenter {
        fun buildLayout()
    }
}