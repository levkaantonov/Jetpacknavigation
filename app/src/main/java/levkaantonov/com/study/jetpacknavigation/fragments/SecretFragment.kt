package levkaantonov.com.study.jetpacknavigation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import levkaantonov.com.study.jetpacknavigation.R
import levkaantonov.com.study.jetpacknavigation.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {
    private var _binding: FragmentSecretBinding? = null
    private val binding
        get() = requireNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecretBinding.bind(view)

        binding.goBackButton.setOnClickListener { findNavController().popBackStack() }
        binding.closeBoxButton.setOnClickListener {
            findNavController().popBackStack(
                R.id.rootFragment,
                false
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}