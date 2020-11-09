package sistemas.jd.gok.challenge.resources.remote.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import sistemas.jd.gok.challenge.domain.model.ProductResponse

interface ProductApi {

    @GET("/products")
    fun getAll(): Deferred<ProductResponse>
}