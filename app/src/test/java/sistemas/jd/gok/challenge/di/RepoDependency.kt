package sistemas.jd.gok.challenge.di

import org.koin.dsl.module
import sistemas.jd.gok.challenge.domain.repository.ProductRepository
import sistemas.jd.gok.challenge.resources.repository.ProductDataRepository

val RepoDependency = module {
    single<ProductRepository> { ProductDataRepository(get()) }
}