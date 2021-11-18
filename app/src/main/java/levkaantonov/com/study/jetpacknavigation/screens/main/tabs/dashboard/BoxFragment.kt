package levkaantonov.com.study.jetpacknavigation.screens.main.tabs.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import levkaantonov.com.study.jetpacknavigation.R
import levkaantonov.com.study.jetpacknavigation.Repositories
import levkaantonov.com.study.jetpacknavigation.databinding.FragmentBoxBinding
import levkaantonov.com.study.jetpacknavigation.utils.observeEvent
import levkaantonov.com.study.jetpacknavigation.utils.viewModelCreator
import levkaantonov.com.study.jetpacknavigation.views.DashboardItemView

class BoxFragment : Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding
    private val args by navArgs<BoxFragmentArgs>()
    private val viewModel by viewModelCreator {
        BoxViewModel(
            getBoxId(),
            Repositories.boxesRepository
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        binding.root.setBackgroundColor(DashboardItemView.getBackgroundColor(getColorValue()))
        binding.boxTextView.text = getString(R.string.this_is_box, getColorName())

        binding.goBackButton.setOnClickListener { onGoBackButtonPressed() }

        listenShouldExitEvent()
    }

    private fun onGoBackButtonPressed() {
        findNavController().popBackStack()
    }

    private fun listenShouldExitEvent() =
        viewModel.shouldExitEvent.observeEvent(viewLifecycleOwner) { shouldExit ->
            if (shouldExit) {
                findNavController().popBackStack()
            }
        }

    private fun getBoxId(): Int = args.boxId

    private fun getColorValue(): Int = args.colorValue

    private fun getColorName(): String = args.boxColor

}