package sistemas.jd.gok.challenge.di

import org.koin.dsl.module
import sistemas.jd.gok.challenge.resources.remote.api.ProductApi

/**
 * Network module test configuration with mockserver url.
 */
fun configureNetworkModuleForTest(baseApi: String)
        = module{
    single { provideOkHttpClient() }
    single { provideGson() }
    single { provideRetrofit(get(), get())}
    single { createApi<ProductApi>(get()) }
}