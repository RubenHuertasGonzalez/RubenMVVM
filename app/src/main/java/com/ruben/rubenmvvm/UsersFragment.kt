package com.ruben.rubenmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ruben.rubenmvvm.databinding.FragmentUsersBinding

class UsersFragment : Fragment(R.layout.fragment_users) {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.userDetailTextView.text = getFormattedUserDetail(viewModel.getSpecificUserDetail() ?: viewModel.getNextUserDetail())

        binding.usersLayout.setOnClickListener {
            binding.userDetailTextView.text = getFormattedUserDetail(viewModel.getNextUserDetail())
        }

        return binding.root
    }

    private fun getFormattedUserDetail(userDetail: UserDetail): String {
        return "Username: ${userDetail.username}\nAge: ${userDetail.age}\nEmail: ${userDetail.email}"
    }
}
