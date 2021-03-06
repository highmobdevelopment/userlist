package erevacation.com.userlist.ui.homescreen.list

import android.support.v7.widget.RecyclerView
import android.util.TimingLogger
import android.view.LayoutInflater
import android.view.ViewGroup
import erevacation.com.userlist.databinding.ViewHolderListBinding
import erevacation.com.userlist.datamodel.ListDM

class ListRecyclerAdapter(val presenter:ListFragmentPresenter)
    : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    private val listInfo: MutableList<ListDM> = mutableListOf()
    private val profileInfoList: ArrayList<String> = arrayListOf()


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindList(listInfo[position].name,
                        listInfo[position].surname,
                        listInfo[position].image)

        holder.binding.listFragmentCard.setOnClickListener {
            this.profileInfoList.clear()
            this.profileInfoList.add(listInfo[position].contactDetails.email)
            this.profileInfoList.add(listInfo[position].contactDetails.address)
            this.profileInfoList.add(listInfo[position].contactDetails.phones.home)
            this.profileInfoList.add(listInfo[position].contactDetails.phones.work)

            presenter.openProfileScreen(listInfo[position].name
                                       ,listInfo[position].surname
                                       ,listInfo[position].image
                                       ,profileInfoList)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val timings = TimingLogger(ListRecyclerAdapter::class.java.simpleName, "onCreateViewHolder")
        val binding = ViewHolderListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        timings.addSplit("onCreateViewHolder done")
        timings.dumpToLog()
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }
    fun updateList(contacts: MutableList<ListDM>) {
        this.listInfo.clear()
        this.listInfo.addAll(contacts)
        notifyDataSetChanged()
    }

    class ListViewHolder(binding: ViewHolderListBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bindList(name : String, surname : String, url : String ) {
            binding.listFragmentCard.setListApperance(name, surname, url)
        }
    }
}

