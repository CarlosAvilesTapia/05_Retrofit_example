package cl.cat2814.a05retrofitexample.userInterface.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import cl.cat2814.a05retrofitexample.R
import cl.cat2814.a05retrofitexample.data.local.LandEntity
import cl.cat2814.a05retrofitexample.data.remote.Land
import cl.cat2814.a05retrofitexample.databinding.LandItemBinding
import coil.load
import coil.transform.CircleCropTransformation

class LandAdapter: RecyclerView.Adapter<LandAdapter.LandItemViewHolder>() {

    private lateinit var binding: LandItemBinding
    private val landList = mutableListOf<LandEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandItemViewHolder {
        binding = LandItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LandAdapter.LandItemViewHolder, position: Int) {
        val land = landList[position]
        holder.bind(land)

        // Aplicación de la animación creada en la carpeta res.
        holder.binding.cvLandItem.startAnimation(
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim_cv)
        )
    }

    override fun getItemCount(): Int {
        return landList.size
    }

    fun setData(lands: List<LandEntity>) {
        this.landList.clear()
        this.landList.addAll(lands)
        notifyDataSetChanged()
    }

    class LandItemViewHolder(val binding: LandItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(land: LandEntity) {
            binding.ivLand.load(land.imgUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }

            binding.cvLandItem.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("landId", land.id)
                findNavController(binding.root).
                navigate(R.id.action_landListFragment_to_landDetailFragment, bundle)
            }
        }
    }
}
