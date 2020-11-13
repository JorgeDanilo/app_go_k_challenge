package sistemas.jd.gok.challenge.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import sistemas.jd.gok.challenge.objects.Variables

class NetworkMonitor constructor(private val application: Application) {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun startNetworkCallback() {
        val connectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val builder = NetworkRequest.Builder()
        connectivityManager.registerNetworkCallback(builder.build(), @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                Variables.isNetworkConnected = true
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                Variables.isNetworkConnected = false
            }
        })
    }
}