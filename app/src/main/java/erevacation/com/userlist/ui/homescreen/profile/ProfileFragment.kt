package erevacation.com.userlist.ui.homescreen.profile

import android.os.Bundle
import erevacation.com.userlist.R
import erevacation.com.userlist.basic.BasicFragment
import erevacation.com.userlist.databinding.FragmentProfileBinding

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
        ,ProfileContract.ProfileView {

    override fun getLayoutId(): Int = R.layout.fragment_profile

    companion object {
        const val PROFILE_FRAGMENT_TAG: String = "THEME_FRAGMENT_TAG"
        fun newInstance(): ProfileFragment {
            val args: Bundle = Bundle()
            val fragment = ProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }
}