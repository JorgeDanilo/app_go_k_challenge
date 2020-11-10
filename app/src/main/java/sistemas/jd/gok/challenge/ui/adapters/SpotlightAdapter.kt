package sistemas.jd.gok.challenge.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.databinding.SpotlightItemBinding
import sistemas.jd.gok.challenge.domain.model.Spotlight

class SpotlightAdapter(
    private val spotlights: List<Spotlight>,
    private val mActivity: Activity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SpotlightViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.spotlight_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as SpotlightViewHolder).binding
        val spotlight = spotlights[position]
        binding.spotlight = spotlight
    }

    override fun getItemCount() = spotlights.size

}

class SpotlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding: SpotlightItemBinding = SpotlightItemBinding.bind(view)
}