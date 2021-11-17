package levkaantonov.com.study.jetpacknavigation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import levkaantonov.com.study.jetpacknavigation.R
import levkaantonov.com.study.jetpacknavigation.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {

    private var _binding: FragmentBoxBinding? = null
    private val binding
        get() = requireNotNull(_binding)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBoxBinding.bind(view)

        val color = requireArguments().getInt(ARG_COLOR)
        binding.root.setBackgroundColor(color)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.openSecretButton.setOnClickListener {
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
        binding.generateNumberButton.setOnClickListener {
            val randomNumber = Random.nextInt()
            parentFragmentManager.setFragmentResult(
                REQUEST_CODE,
                bundleOf(EXTRA_RANDOM_NUMBER to randomNumber)
            )
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_COLOR = "color"

        const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}