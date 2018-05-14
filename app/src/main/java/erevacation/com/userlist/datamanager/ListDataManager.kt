package erevacation.com.userlist.datamanager

import com.google.gson.GsonBuilder
import erevacation.com.userlist.datamodel.ListDM
import io.reactivex.Observable
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject


class ListDataManager @Inject constructor() : ListDataManagerContract {

    val url: String ="https://raw.githubusercontent.com/highmobdevelopment/userlist/master/contacts.json"

    override fun getList(): Observable<MutableList<ListDM>> {
        return Observable.create<MutableList<ListDM>> { respons ->
            val request = Request.Builder().url(url).build()
            val client = OkHttpClient()
            val list = ArrayList<ListDM>()
            client.newCall(request).enqueue(object : Callback {
                override fun onResponse(call: Call?, response: Response?) {
                    val body = response?.body()?.string()
                    val gson = GsonBuilder().create()
                    val JsonObject = JSONObject(body)
                    val JsonArray = JsonObject.getJSONArray("contact")
                    for (i in 0 until JsonArray.length()) {
                        list.add(gson.fromJson(JsonArray.getJSONObject(i).toString(), ListDM::class.java))
                    }
                    respons.onNext(list)
                    respons.onComplete()
                }

                override fun onFailure(call: Call?, e: IOException?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        }
    }
}