package com.kotlin.kotlinprojectdemo.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiBuilder {
    private const val BASE_URL_1 = "https://5e510330f2c0d300147c034c.mockapi.io/"

    private var retrofit: Retrofit? = null
    private const val REQUEST_TIMEOUT = 60
    private var okHttpClient: OkHttpClient? = null

    fun getClient(): Retrofit? {
        if (okHttpClient == null) initOkhttp()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_1)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                /*remember check version retrofit when bug
                Unable to create call adapter for class java.lang.Object for method retrofit
                because version old it will incompatible*/
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        return retrofit
    }

    private fun initOkhttp() {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(interceptor)

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val request = requestBuilder.cacheControl(CacheControl.FORCE_NETWORK).build()
            chain.proceed(request)
        }
        okHttpClient = httpClient.build()
    }

    val apiInterface: ApiInterface = getClient()!!.create(ApiInterface::class.java)
}