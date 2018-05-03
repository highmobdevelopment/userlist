package erevacation.com.userlist.ui.homescreen.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import erevacation.com.userlist.databinding.ViewHolderListBinding

class ListRecyclerAdapter() : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    var listInfo: MutableList<String> = mutableListOf()

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ViewHolderListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    class ListViewHolder(binding: ViewHolderListBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}

