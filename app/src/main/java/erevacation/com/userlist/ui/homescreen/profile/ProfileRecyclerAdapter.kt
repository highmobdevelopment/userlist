package erevacation.com.userlist.ui.homescreen.profile

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import erevacation.com.userlist.databinding.ViewHolderProfileBinding

class ProfileRecyclerAdapter (val presenter: ProfileFragmentPresenter) : RecyclerView.Adapter<ProfileRecyclerAdapter.ProfileViewHolder>() {

    var names: MutableList<String> = mutableListOf("Djordje Moljkovic")
    var email: MutableList<String> = mutableListOf("djmoljkovic@gmail.com")
    var location: MutableList<String> = mutableListOf("Kremna")


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProfileViewHolder {
        val binding = ViewHolderProfileBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  names.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind("",names[position],email[position])
    }

    class ProfileViewHolder(binding: ViewHolderProfileBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bind(imageurl: String, name: String, email:String) {
            binding.profileFragmentCard.setListApperance(imageurl,name,email)
        }
    }


}