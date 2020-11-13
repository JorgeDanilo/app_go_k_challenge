package sistemas.jd.gok.challenge.domain.repository

import sistemas.jd.gok.challenge.domain.model.ProductResponse

interface ProductRepository {

    suspend fun getAll(): ProductResponse
}