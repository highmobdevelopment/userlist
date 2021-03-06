package erevacation.com.userlist.ui.homescreen.list

import erevacation.com.userlist.R
import erevacation.com.userlist.basic.BasicFragment
import erevacation.com.userlist.databinding.FragmentListBinding

class ListFragment : BasicFragment<ListContract.ListPresenter, FragmentListBinding>(), ListContract.ListView {

    override fun getLayoutId(): Int = R.layout.fragment_list
}