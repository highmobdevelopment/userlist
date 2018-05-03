package erevacation.com.userlist.ui.homescreen.list

import erevacation.com.userlist.basic.arhitecture.ViperContract

interface ListContract {
    interface ListView : ViperContract.View<ListPresenter> {

    }
    interface ListPresenter : ViperContract.Presenter {

    }
}