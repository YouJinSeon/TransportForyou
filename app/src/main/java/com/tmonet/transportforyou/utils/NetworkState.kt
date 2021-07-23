package com.tmonet.transportforyou.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest


/**
 * 네트워크 상태
 */
class NetworkState(context: Context) : ConnectivityManager.NetworkCallback() {

    private var context: Context? = null
    private var networkRequest: NetworkRequest? = null
    private var connectivityManager: ConnectivityManager? = null

    init {
        this.context = context
        this.networkRequest =
            NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI).build()
    }

    /**
     * 네트워크 상태 감지 등록
     */
    fun register() {
        connectivityManager =
            context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager!!.registerNetworkCallback(networkRequest!!, this)
    }

    /**
     * 네트워크 상태 감지 해제
     */
    fun unregister() {
        connectivityManager!!.unregisterNetworkCallback(this)
    }

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        // Do what you need to do here
        // 네트워크가 연결되었을 때 할 동작

    }

    override fun onLost(network: Network) {
        super.onLost(network)
        // Do what you need to do here
        // 네트워크 연결이 끊겼을 때 할 동작

    }
}
