package erevacation.com.userlist.usecase

import erevacation.com.userlist.datamodel.ListDM

interface ListUCContract {
    fun getList()
    fun setListUCOut(ListUCOut: ListUCOut)
    fun clearRequests()
    interface ListUCOut {
        fun publishListResults(list: MutableList<ListDM>)
    }
}