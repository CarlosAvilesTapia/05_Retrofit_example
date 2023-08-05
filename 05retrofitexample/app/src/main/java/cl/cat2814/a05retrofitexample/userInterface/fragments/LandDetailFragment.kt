package cl.cat2814.a05retrofitexample.userInterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cat2814.a05retrofitexample.R
import cl.cat2814.a05retrofitexample.databinding.FragmentLandDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "landId"


/**
 * A simple [Fragment] subclass.
 * Use the [LandDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LandDetailFragment : Fragment() {

    private lateinit var binding: FragmentLandDetailBinding


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

        binding.tvLandId.text = param1

        return binding.root
    }


}