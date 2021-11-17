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
        binding.greenBoxButton.setOnClickListener {
            openBox(
                Color.rgb(200, 255, 200),
                getString(R.string.GreenLabel)
            )
        }
        binding.yellowBoxButton.setOnClickListener {
            openBox(
                Color.rgb(255, 255, 200),
                getString(R.string.YellowLabel)
            )
        }

        val liveData =
            findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Int>(
                BoxFragment.EXTRA_RANDOM_NUMBER
            )
        liveData?.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), "Generated number $it", Toast.LENGTH_SHORT)
                    .show()
                liveData.value = null
            }
        }
    }

    private fun openBox(color: Int, colorName: String) {
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(color, colorName)
        findNavController().navigate(direction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}