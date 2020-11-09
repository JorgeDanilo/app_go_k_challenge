package sistemas.jd.gok.challenge.domain.model

data class ProductResponse(
    val cash: Cash,
    val products: List<Product>,
    val spotlight: List<Spotlight>
)