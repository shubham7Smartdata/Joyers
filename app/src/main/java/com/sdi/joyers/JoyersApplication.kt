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

    override fun onCreate() {
        super.onCreate()
        instance = this
//        MultiDex.install(this)
    }

//
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