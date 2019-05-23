package com.sdi.joyers

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager

/**
 *
 * This is an Application Class
 * It initializes Networking Library
 *
 */
class JoyersApplication : Application() {

    val TAG = JoyersApplication::class.java!!
        .getSimpleName()
    private var instance: JoyersApplication? = null

    fun getInstance(): JoyersApplication? {
        return instance
    }

    fun hasNetwork(): Boolean {
        return instance!!.checkIfHasNetwork()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
//        MultiDex.install(this)
    }

    fun checkIfHasNetwork(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }



//    override fun onCreate() {
//        super.onCreate()
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BASIC
//
//
//        val client:OkHttpClient = OkHttpClient().newBuilder()
//            .connectTimeout(120,TimeUnit.SECONDS)
//            .readTimeout(120,TimeUnit.SECONDS)
//            .writeTimeout(120,TimeUnit.SECONDS)
//            .addInterceptor(logging)
//            .build()
//
//        AndroidNetworking.initialize(applicationContext,client)
//    }


}