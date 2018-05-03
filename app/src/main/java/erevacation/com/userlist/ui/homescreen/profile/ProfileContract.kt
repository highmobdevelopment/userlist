package erevacation.com.userlist.ui.homescreen.profile

import erevacation.com.userlist.basic.arhitecture.ViperContract

interface ProfileContract {


    interface ProfileView : ViperContract.View<ProfilePresenter> {

    }

    interface ProfilePresenter : ViperContract.Presenter {

    }

}