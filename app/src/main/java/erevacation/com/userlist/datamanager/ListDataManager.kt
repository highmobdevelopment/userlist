package erevacation.com.userlist.datamanager

import com.erevacation.networking.ApiService
import erevacation.com.userlist.datamodel.ListDM
import io.reactivex.Observable
import javax.inject.Inject


class ListDataManager @Inject constructor(var apiService: ApiService) : ListDataManagerContract {

    override fun getList(): Observable<MutableList<ListDM>> {
        return apiService.getList()
                .flatMapIterable { list -> list }
                .map { item -> ListDM(item) }
                .toList()
                .toObservable()

    }
}