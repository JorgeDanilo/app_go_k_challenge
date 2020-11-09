package sistemas.jd.gok.challenge.resources.repository

import sistemas.jd.gok.challenge.domain.model.ProductResponse
import sistemas.jd.gok.challenge.domain.repository.ProductRepository
import sistemas.jd.gok.challenge.resources.remote.api.ProductApi

class ProductDataRepository(private val api: ProductApi): ProductRepository {

    override suspend fun getAll(): ProductResponse {
        TODO("Not yet implemented")
    }


}