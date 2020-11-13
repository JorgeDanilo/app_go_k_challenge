package sistemas.jd.gok.challenge.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.databinding.SpotlightItemBinding
import sistemas.jd.gok.challenge.domain.model.Spotlight


class SpotlightAdapterViewPager(
    private val spotlights: List<Spotlight>,
    private val context: Context
) : PagerAdapter() {

    override fun getCount(): Int = spotlights.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater
            .from(this.context)
            .inflate(R.layout.spotlight_item, container, false)

        val binding = SpotlightItemBinding.bind(view)
        val spotlight = spotlights[position]
        binding.spotlight = spotlight
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View?)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }



}
   /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
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
}*/