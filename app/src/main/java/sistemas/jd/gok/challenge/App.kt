package sistemas.jd.gok.challenge

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import sistemas.jd.gok.challenge.di.remoteModule
import sistemas.jd.gok.challenge.di.repositoryModule
import sistemas.jd.gok.challenge.di.uiModule
import sistemas.jd.gok.challenge.utils.NetworkMonitor

class App: Application() {

    private val appModules by lazy {
        listOf(remoteModule, repositoryModule, uiModule)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate() {
        super.onCreate()
        NetworkMonitor(this).startNetworkCallback()
        startKoin()
        Fresco.initialize(this)
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(appModules)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}