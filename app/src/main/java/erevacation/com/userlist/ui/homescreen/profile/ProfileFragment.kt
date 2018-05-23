package erevacation.com.userlist.ui.homescreen.profile

import android.os.Bundle
import erevacation.com.userlist.R
import erevacation.com.userlist.basic.BasicFragment
import erevacation.com.userlist.databinding.FragmentProfileBinding

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter, FragmentProfileBinding>()
        , ProfileContract.ProfileView {

    var name: String = ""
    var surname: String = ""
    var image: String = ""
    var profileInfoList: ArrayList<String> = arrayListOf()
    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun onStart() {
        this.name = arguments!!.getString(NAME)
        this.surname = arguments!!.getString(SURNAME)
        this.image = arguments!!.getString(IMAGE)
        this.profileInfoList = arguments!!.getStringArrayList(PROFILEINFOLIST)
        super.onStart()
    }

    companion object {
        private val NAME = "name"
        private val SURNAME = "surname"
        private val IMAGE = "image"
        private val PROFILEINFOLIST = "profileInfoList"
        const val PROFILE_FRAGMENT_TAG: String = "PROFILE_FRAGMENT_TAG"
        fun newInstance(name: String, surname: String, image: String, profileInfoList: ArrayList<String>): ProfileFragment {

            val args: Bundle = Bundle()
            args.putStringArrayList(PROFILEINFOLIST, profileInfoList)
            args.putSerializable(NAME, name)
            args.putSerializable(SURNAME, surname)
            args.putSerializable(IMAGE, image)
            val fragment = ProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }
}