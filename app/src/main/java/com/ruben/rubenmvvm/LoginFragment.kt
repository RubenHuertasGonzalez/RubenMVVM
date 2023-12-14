package com.ruben.rubenmvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ruben.rubenmvvm.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.nextButton.setOnClickListener {
            viewModel.enteredUsername = binding.usernameEditText.text.toString()
            viewModel.enteredPassword = binding.passwordEditText.text.toString()

            viewModel.isLoginValid()

            if (viewModel.currentUser.value != null) {
                val usersViewModel = ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)
                usersViewModel.updateCurrentUser(viewModel.currentUser.value)

                model.login(binding.usernameEditText.text.toString(), binding.passwordEditText.text.toString())

                findNavController().navigate(R.id.action_loginFragment_to_usersFragment)
            } else {
                showErrorMessage()
            }
        }
    }

    private fun showErrorMessage() {
        Toast.makeText(requireContext(), "Te has equivocado, comprueba el usuario o contraseña", Toast.LENGTH_SHORT).show()
    }
}



