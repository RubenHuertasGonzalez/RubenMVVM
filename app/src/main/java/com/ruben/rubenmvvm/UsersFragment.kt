package com.ruben.rubenmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ruben.rubenmvvm.databinding.FragmentUsersBinding

class UsersFragment : Fragment(R.layout.fragment_users) {

    private val sharedViewModel: SharedViewModel by viewModels()
    private lateinit var binding: FragmentUsersBinding
    private lateinit var viewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        model._user.observe(viewLifecycleOwner,Observer {
            binding.userDetailTextView.text = it.username
            binding.passwordTextView.text = it.password
        })

//        binding.viewModel = viewModel
//        binding.lifecycleOwner = viewLifecycleOwner
//
//        viewModel.userDetailLiveData.observe(viewLifecycleOwner, Observer { userDetail ->
//            binding.userDetailTextView.text = getFormattedUserDetail(userDetail)
//        })
//
//        binding.usersLayout.setOnClickListener {
//            viewModel.updateCurrentUser(viewModel.getNextUserDetail())
//        }

        return binding.root
    }

    private fun getFormattedUserDetail(userDetail: UserDetail): String {
        return "Username: ${userDetail.username}\nPassword: ${userDetail.password}"
    }
}


