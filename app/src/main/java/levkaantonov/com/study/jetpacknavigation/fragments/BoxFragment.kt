package levkaantonov.com.study.jetpacknavigation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import levkaantonov.com.study.jetpacknavigation.R
import levkaantonov.com.study.jetpacknavigation.databinding.FragmentBoxBinding
import levkaantonov.com.study.jetpacknavigation.publishResults
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {

    private var _binding: FragmentBoxBinding? = null
    private val binding
        get() = requireNotNull(_binding)
    private val args by navArgs<BoxFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBoxBinding.bind(view)

        val color = args.color
        binding.root.setBackgroundColor(color)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.openSecretButton.setOnClickListener {
            findNavController().navigate(BoxFragmentDirections.actionBoxFragmentToSecretFragment())
        }
        binding.generateNumberButton.setOnClickListener {
            val randomNumber = Random.nextInt()
            publishResults(EXTRA_RANDOM_NUMBER, randomNumber)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}