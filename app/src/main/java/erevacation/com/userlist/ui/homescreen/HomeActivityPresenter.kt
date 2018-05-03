package erevacation.com.userlist.ui.homescreen

import android.app.Fragment
import android.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem
import erevacation.com.userlist.R
import erevacation.com.userlist.basic.arhitecture.ViperContract
import erevacation.com.userlist.databinding.ActivityHomeBinding
import erevacation.com.userlist.ui.homescreen.adapter.ViewPagerAdapter
import erevacation.com.userlist.ui.homescreen.list.ListFragment
import javax.inject.Inject

class HomeActivityPresenter @Inject constructor() : HomeContract.HomePresenter {



    private val TAG: String = "HomeActivityPresenter"
    private var view: HomeContract.HomeView? = null
    private var binding: ActivityHomeBinding? = null
    private lateinit var fragmentManager: FragmentManager
    private var listFragment: ListFragment = ListFragment()
    private var adapter: ViewPagerAdapter? = null


    // overrides that every presenter have
    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as HomeContract.HomeView
        this.binding = (this.view as? HomeActivity)?.binding
        fragmentManager = (this.view as HomeActivity).fragmentManager
        adapter = ViewPagerAdapter((view as HomeActivity).supportFragmentManager)
        setupViewPager()
        buildLayout()
    }
    override fun viewDetach() {
        this.view = null
        this.binding = null
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    override fun buildLayout() {

    }

    private fun setupViewPager() {
        adapter?.addFragment(listFragment)
        binding?.viewpager?.adapter = adapter

    }
}