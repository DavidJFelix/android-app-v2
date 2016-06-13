package co.instameals.dinnersolutions.api.v2.http

import co.instameals.dinnersolutions.api.v2.AuthManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthHeaderInterceptor(val authManager: AuthManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        val requestBuilder = chain
                ?.request()
                ?.newBuilder()

        if (authManager.isAuthenticated()) {
            requestBuilder?.addHeader("Authentication", authManager.getBearerToken())
        }
        return chain?.proceed(requestBuilder?.build())

    }

}