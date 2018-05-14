package erevacation.com.userlist.usecase

import erevacation.com.userlist.datamodel.ListDM

interface ListUCContract {
    fun getList()
    fun setListUCOut(ListUCOut: ListUCOut)
    interface ListUCOut {
        fun publishListResults(list: MutableList<ListDM>)
    }
}