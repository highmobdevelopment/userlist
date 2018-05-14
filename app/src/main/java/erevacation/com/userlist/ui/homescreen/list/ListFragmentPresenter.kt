package erevacation.com.userlist.ui.homescreen.list

import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import erevacation.com.userlist.R
import erevacation.com.userlist.basic.arhitecture.ViperContract
import erevacation.com.userlist.databinding.FragmentListBinding
import erevacation.com.userlist.datamodel.ListDM
import erevacation.com.userlist.ui.homescreen.HomeActivity
import erevacation.com.userlist.ui.homescreen.profile.ProfileFragment
import erevacation.com.userlist.usecase.ListUC
import erevacation.com.userlist.usecase.ListUCContract
import javax.inject.Inject

class ListFragmentPresenter @Inject constructor(val listUC: ListUC) : ListContract.ListPresenter,ListUCContract.ListUCOut{


    private val listAdapter = ListRecyclerAdapter(this)
    private var view: ListContract.ListView? = null
    private var binding: FragmentListBinding? = null
    private lateinit var fragmentManager: FragmentManager

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ListContract.ListView
        this.binding = (this.view as? ListFragment)?.binding
        this.listUC.setListUCOut(this)
        fragmentManager = (binding?.root?.context as HomeActivity).supportFragmentManager
        listUC.getList()
        buildLayout()
    }
    override fun publishListResults(list: MutableList<ListDM>) {
        listAdapter.updateList(list)
    }

    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }

    override fun openProfileScreen(name: String, surname: String, image: String, profileInfoList: ArrayList<String>) {

        val fragmentProfile = ProfileFragment.newInstance(name, surname, image, profileInfoList)

        fragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.right_in, R.animator.fui_slide_out_left, R.animator.fui_slide_in_right, R.animator.right_out)
                .add(R.id.constrain_activity_home, fragmentProfile)
                .addToBackStack("contacts_back_stack")
                .commit()

    }

    private fun buildLayout() {
        binding?.listRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.listRecyclerView?.adapter = listAdapter
    }


}