package ng.com.intellifarms.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import ng.com.intellifarms.R
import ng.com.intellifarms.databinding.FragmentSignInBinding
import ng.com.intellifarms.model.request.SignInRequest

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SignInFragment : Fragment() {

        lateinit var viewModelFactory: ViewModelProvider.Factory

        private lateinit var signInViewModel: SignInViewModel

        lateinit var binding: FragmentSignInBinding

        private var overrideNavigationFlow = false

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentSignInBinding.inflate(inflater)
            binding.lifecycleOwner = this
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // ViewModel setup
            signInViewModel = ViewModelProviders.of(this, viewModelFactory).get(SignInViewModel::class.java)
            //binding. = signInViewModel

            binding.signInButton.setOnClickListener {
                if (validateTextLayouts(binding.usernameEditText, binding.passwordEditText)) {
                    signInViewModel.signIn(
                        SignInRequest(
                            binding.usernameEditText.text.toString(),
                            binding.passwordEditText.text.toString()
                        )
                    )
                    findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
                }
            }

        }

    fun validateTextLayouts(vararg textLayouts: TextView): Boolean {
        clearTextLayoutError(*textLayouts)
        for (textLayout in textLayouts) {
            if (!textLayout.validate()) return false
        }
        return true
    }

    fun clearTextLayoutError(vararg textLayouts: TextView) {
        for (textLayout in textLayouts) textLayout.error = null
    }

    fun TextView.isEmpty() = text.isNullOrEmpty()

    fun TextView.validate(errorMessage: String = "This Field is required"): Boolean {
        if (!isEmpty()) return true
        error = errorMessage
        return false
    }
}