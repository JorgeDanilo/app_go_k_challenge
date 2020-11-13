package sistemas.jd.gok.challenge.domain.model

import java.io.Serializable

data class Product(
    val description: String,
    val imageURL: String,
    val name: String
): Serializable