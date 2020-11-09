package sistemas.jd.gok.challenge.di

import org.koin.dsl.module
import sistemas.jd.gok.challenge.resources.remote.api.ProductApi

val uiModule = module {

}

val repositoryModule = module {

}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideGson() }
    single { provideRetrofit(get(), get())}
    single { createApi<ProductApi>(get()) }
}