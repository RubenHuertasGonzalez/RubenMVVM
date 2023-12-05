package com.ruben.rubenmvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ruben.rubenmvvm.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        binding.nextButton.setOnClickListener {
            viewModel.enteredUsername = binding.usernameEditText.text.toString()
            viewModel.enteredPassword = binding.passwordEditText.text.toString()

            if (viewModel.isLoginValid()) {
                val usersViewModel = ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)
                usersViewModel.currentUser = viewModel.currentUser

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

