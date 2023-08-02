package cl.cat2814.a05retrofitexample.userInterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.cat2814.a05retrofitexample.R
import cl.cat2814.a05retrofitexample.databinding.FragmentLandListBinding

class LandListFragment : Fragment() {

    lateinit var binding: FragmentLandListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLandListBinding.inflate(layoutInflater, container, false)



        return binding.root
    }
}