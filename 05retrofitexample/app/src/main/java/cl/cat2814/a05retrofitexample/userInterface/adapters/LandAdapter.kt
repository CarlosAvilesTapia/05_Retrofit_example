package cl.cat2814.a05retrofitexample.userInterface.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.cat2814.a05retrofitexample.data.remote.Land
import cl.cat2814.a05retrofitexample.databinding.LandItemBinding
import coil.load
import coil.transform.CircleCropTransformation

class LandAdapter: RecyclerView.Adapter<LandAdapter.LandItemViewHolder>() {

    private lateinit var binding: LandItemBinding
    private val landList = mutableListOf<Land>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandItemViewHolder {
        binding = LandItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LandAdapter.LandItemViewHolder, position: Int) {
        val land = landList[position]
        holder.bind(land)
    }

    override fun getItemCount(): Int {
        return landList.size
    }

    fun setData(land: List<Land>) {
        this.landList.clear()
        this.landList.addAll(land)
        notifyDataSetChanged()
    }

    class LandItemViewHolder(val binding: LandItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(land: Land) {
            binding.ivLand.load(land.imgUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }
    }
}
