package sistemas.jd.gok.challenge.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.utils.RoundedCornersTransformation

@BindingAdapter(
    "bind:imageUrl",
    "bind:cornerSize",
    requireAll = false
)
fun ImageView.imageFromUrl(
    imageUrl: String,
    cornerSize: Int?
) {
    if (cornerSize != null) {
        loadRoundedImageView(
            this,
            imageUrl,
            cornerSize,
            RoundedCornersTransformation.CornerType.ALL
        )
    } else {
        loadImageView(this, imageUrl)
    }
}

fun loadRoundedImageView(
    imageView: ImageView,
    imageUrl: String,
    cornerSize: Int,
    cornerType: RoundedCornersTransformation.CornerType?
) {

    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions().dontTransform())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}

fun loadImageView(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView.context)
        .load(imageUrl)
        .placeholder(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions().dontTransform())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}
