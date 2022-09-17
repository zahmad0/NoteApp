package com.zhr.noteapp.api

import android.util.Log
import com.zhr.noteapp.utils.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    @Inject
    lateinit var tokenManager: TokenManager

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        val token = tokenManager.getToken()
        request.addHeader("Authorization", "Bearer $token")
        val fr = request.build()
        Log.d("XXZ","URL = ${fr.url}")
        Log.d("XXZ","URL = ${fr.headers}")
        Log.d("XXZ","URL = ${fr.body}")
        return chain.proceed(fr)
    }
}