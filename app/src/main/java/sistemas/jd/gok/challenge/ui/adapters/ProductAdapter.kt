package sistemas.jd.gok.challenge.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.databinding.ProductItemBinding
import sistemas.jd.gok.challenge.domain.model.Product

class ProductAdapter(
    private val products: List<Product>,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ProductViewHolder).binding
        val product = products[position]
        binding.product = product
    }

    override fun getItemCount(): Int = products.size
}

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding: ProductItemBinding = ProductItemBinding.bind(view)
}