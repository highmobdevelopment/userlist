package erevacation.com.userlist.datamanager

import erevacation.com.userlist.basic.arhitecture.ViperContract
import erevacation.com.userlist.datamodel.ListDM
import io.reactivex.Observable

interface ListDataManagerContract : ViperContract.DataManager {

    fun getList(): Observable<MutableList<ListDM>>
}