package sistemas.jd.gok.challenge.model.entity

data class Result(
    val cash: Cash,
    val products: List<Product>,
    val spotlight: List<Spotlight>
)