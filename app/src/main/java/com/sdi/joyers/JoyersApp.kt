package com.sdi.joyers

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *
 * This is an Application Class
 * It initializes Networking Library
 *
 */
class JoyersApp: Application() {

    override fun onCreate() {
        super.onCreate()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC


        val client:OkHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(120,TimeUnit.SECONDS)
            .readTimeout(120,TimeUnit.SECONDS)
            .writeTimeout(120,TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()

        AndroidNetworking.initialize(applicationContext,client)
    }


}