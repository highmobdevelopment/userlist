package erevacation.com.userlist.ui.homescreen.profile

import android.os.Bundle
import erevacation.com.userlist.R
import erevacation.com.userlist.basic.BasicFragment
import erevacation.com.userlist.databinding.FragmentProfileBinding

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
        ,ProfileContract.ProfileView {

    var user: String = ""

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onStart() {
        this.user = arguments!!.getString(USER)
        super.onStart()
    }

    companion object {
        private val USER = "user"
        const val PROFILE_FRAGMENT_TAG: String = "PROFILE_FRAGMENT_TAG"
        fun newInstance(user :String): ProfileFragment {
            val args: Bundle = Bundle()
            args.putSerializable(USER,user)
            val fragment = ProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }
}