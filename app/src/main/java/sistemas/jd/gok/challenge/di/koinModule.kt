package sistemas.jd.gok.challenge.di

import org.koin.dsl.module
import sistemas.jd.gok.challenge.domain.repository.ProductRepository
import sistemas.jd.gok.challenge.resources.remote.api.ProductApi
import sistemas.jd.gok.challenge.resources.repository.ProductDataRepository
import sistemas.jd.gok.challenge.viewmodel.MainViewModel

val uiModule = module {
    single { MainViewModel(get()) }
}

val repositoryModule = module {
    single<ProductRepository> {ProductDataRepository(get())}
}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideGson() }
    single { provideRetrofit(get(), get())}
    single { createApi<ProductApi>(get()) }
}