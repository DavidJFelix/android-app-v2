package co.instameals.dinnersolutions.dagger;

import co.instameals.dinnersolutions.api.v2.AuthManager;
import javax.inject.Singleton;

import co.instameals.dinnersolutions.api.v2.http.AuthHeaderInterceptor;
import dagger.Module;
import dagger.Provides;

@Module
public class APIClientModule {

    @Provides
    @Singleton
    AuthHeaderInterceptor provideAuthHeaderInterceptor(AuthManager authManager) {
        return new AuthHeaderInterceptor(authManager);
    }
}
