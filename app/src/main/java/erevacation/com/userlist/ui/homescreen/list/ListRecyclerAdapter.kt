package erevacation.com.userlist.ui.homescreen.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import erevacation.com.userlist.databinding.ViewHolderListBinding

class ListRecyclerAdapter(val presenter:ListFragmentPresenter)
    : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    private val listInfo: MutableList<String> = mutableListOf("John","Jack","Mark","Joshua","Robert")

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bindList(listInfo[position])
        holder.binding.listFragmentCard.setOnClickListener {
            presenter.onListCardClick()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ViewHolderListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    class ListViewHolder(binding: ViewHolderListBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bindList(list : String) {
            binding.listFragmentCard.setListApperance(list)
        }
    }
}

