package co.instameals.dinnersolutions.dagger

import co.instameals.dinnersolutions.api.v2.AuthManager
import javax.inject.Singleton

import co.instameals.dinnersolutions.api.v2.http.AuthHeaderInterceptor
import dagger.Module
import dagger.Provides

@Module
class APIClientModule {

    @Provides
    @Singleton
    fun provideAuthHeaderInterceptor(authManager: AuthManager): AuthHeaderInterceptor {
        return AuthHeaderInterceptor(authManager)
    }
}
