package sistemas.jd.gok.challenge.model.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import sistemas.jd.gok.challenge.model.entity.Result

interface ProductApi {

    @GET("")
    fun getAll(): Deferred<Result>
}