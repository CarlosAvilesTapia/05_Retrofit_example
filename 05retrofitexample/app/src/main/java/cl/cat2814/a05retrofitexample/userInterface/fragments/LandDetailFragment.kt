package cl.cat2814.a05retrofitexample.userInterface.fragments

import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.cat2814.a05retrofitexample.R
import cl.cat2814.a05retrofitexample.databinding.FragmentLandDetailBinding
import cl.cat2814.a05retrofitexample.userInterface.viewModel.LandViewModel
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import java.util.Locale

private const val ARG_PARAM1 = "landId"

class LandDetailFragment : Fragment() {

    private lateinit var binding: FragmentLandDetailBinding
    private val landViewModel: LandViewModel by activityViewModels()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandDetailBinding.inflate(layoutInflater, container, false)

        initListener()

        initViewModel()

        return binding.root
    }

    private fun initListener() {
        binding.btBackToList.setOnClickListener {
            findNavController().navigate(R.id.action_landDetailFragment_to_landListFragment)
        }
    }

    private fun initViewModel() {
        landViewModel.liveDataLandFromRepository(param1.toString()).observe(viewLifecycleOwner) {
            binding.tvLandId.text = it.id
            binding.tvLandPrice.text = landViewModel.getPriceFormat(it.price)
            binding.tvLandType.text = it.type
            binding.ivLandImage.load(it.imgUrl) {
                transformations(RoundedCornersTransformation(20f))
            }
        }
    }
}