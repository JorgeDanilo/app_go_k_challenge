package sistemas.jd.gok.challenge

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import sistemas.jd.gok.challenge.di.remoteModule
import sistemas.jd.gok.challenge.di.repositoryModule
import sistemas.jd.gok.challenge.di.uiModule

class App: Application() {

    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(appModules)
        }
        Fresco.initialize(this)
    }
}