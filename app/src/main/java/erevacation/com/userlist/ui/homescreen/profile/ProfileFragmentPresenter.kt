package erevacation.com.userlist.ui.homescreen.profile

import android.support.v7.widget.LinearLayoutManager
import erevacation.com.userlist.basic.arhitecture.ViperContract
import erevacation.com.userlist.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragmentPresenter @Inject constructor() : ProfileContract.ProfilePresenter {

    private var view: ProfileContract.ProfileView? = null
    private var binding: FragmentProfileBinding? = null
    private val profileAdapter = ProfileRecyclerAdapter(this)

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ProfileContract.ProfileView
        this.binding = (this.view as?ProfileFragment)?.binding
        buildLayout()
        publishUserDetails((view as ProfileFragment).user)
    }


    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
        this.binding = null
    }
    private fun publishUserDetails(name :String){
        profileAdapter.updateUserDetails(name)
    }

    private fun buildLayout(){
        binding?.profileRecyclerView?.layoutManager = LinearLayoutManager(binding?.root?.context)
        binding?.profileRecyclerView?.adapter = profileAdapter
    }
}