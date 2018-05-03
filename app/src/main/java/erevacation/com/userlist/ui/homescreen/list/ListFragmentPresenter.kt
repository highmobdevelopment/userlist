package erevacation.com.userlist.ui.homescreen.list

import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import erevacation.com.userlist.basic.arhitecture.ViperContract
import erevacation.com.userlist.databinding.FragmentListBinding
import erevacation.com.userlist.ui.homescreen.HomeActivity
import javax.inject.Inject

class ListFragmentPresenter @Inject constructor() : ListContract.ListPresenter {

    private val listAdapter = ListRecyclerAdapter(this)
    private var view: ListContract.ListView? = null
    private var binding: FragmentListBinding? = null
    private lateinit var fragmentManager: FragmentManager

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ListContract.ListView
        this.binding = (this.view as? ListFragment)?.binding
        fragmentManager = (binding?.root?.context as HomeActivity).supportFragmentManager

        buildLayout()
    }

    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    override fun onListCardClick() {

    }

    private fun buildLayout() {
        binding?.listRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.listRecyclerView?.adapter = listAdapter
    }


}