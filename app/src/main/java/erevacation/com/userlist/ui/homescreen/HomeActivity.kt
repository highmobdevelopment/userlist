package erevacation.com.userlist.ui.homescreen

import erevacation.com.userlist.R
import erevacation.com.userlist.basic.BasicActivity
import erevacation.com.userlist.databinding.ActivityHomeBinding


class HomeActivity : BasicActivity<HomeContract.HomePresenter, ActivityHomeBinding>(), HomeContract.HomeView {
    private val TAG: String = HomeActivity::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun onStart() {
        super.onStart()

    }

    override fun onBackPressed() {
     super.onBackPressed()

    }

}