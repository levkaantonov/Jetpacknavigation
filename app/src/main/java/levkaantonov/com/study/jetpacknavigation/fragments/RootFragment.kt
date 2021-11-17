package levkaantonov.com.study.jetpacknavigation.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import levkaantonov.com.study.jetpacknavigation.R
import levkaantonov.com.study.jetpacknavigation.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {
    private var _binding: FragmentRootBinding? = null
    private val binding
        get() = requireNotNull(_binding)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRootBinding.bind(view)
        binding.greenBoxButton.setOnClickListener { openBox(Color.rgb(200, 255, 200)) }
        binding.yellowBoxButton.setOnClickListener { openBox(Color.rgb(255, 255, 200)) }

        parentFragmentManager.setFragmentResultListener(
            BoxFragment.REQUEST_CODE,
            viewLifecycleOwner,
            { _, data ->
                val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
                Toast.makeText(requireContext(), "Generated number $number", Toast.LENGTH_SHORT)
                    .show()
            }
        )
    }

    private fun openBox(color: Int) {
        findNavController().navigate(
            R.id.action_rootFragment_to_boxFragment,
            bundleOf(BoxFragment.ARG_COLOR to color)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}