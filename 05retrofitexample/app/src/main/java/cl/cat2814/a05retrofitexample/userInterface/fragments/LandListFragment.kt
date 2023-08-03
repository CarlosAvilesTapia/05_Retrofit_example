package cl.cat2814.a05retrofitexample.userInterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.cat2814.a05retrofitexample.databinding.FragmentLandListBinding
import cl.cat2814.a05retrofitexample.userInterface.viewModel.LandViewModel
import cl.cat2814.a05retrofitexample.userInterface.adapters.LandAdapter

class LandListFragment : Fragment() {

    private lateinit var binding: FragmentLandListBinding
    private val landViewModel: LandViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandListBinding.inflate(layoutInflater, container, false)

        initListener()

        initAdapter()

        return binding.root
    }

    private fun initListener() {
        binding.btLoadData.setOnClickListener {
            landViewModel.getAllLands()
        }
    }

    private fun initAdapter() {
        val landAdapter = LandAdapter()
        binding.rvLandList.adapter = landAdapter
        landViewModel.liveDataLands.observe(viewLifecycleOwner) {
            landAdapter.setData(it)
        }
    }
}