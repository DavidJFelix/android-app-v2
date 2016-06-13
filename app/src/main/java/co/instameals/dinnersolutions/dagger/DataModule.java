package co.instameals.dinnersolutions.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.module.kotlin.KotlinModule;

import javax.inject.Singleton;

import co.instameals.dinnersolutions.api.v2.AuthManager;
import dagger.Module;
import dagger.Provides;

@Module(includes = {APIClientModule.class})
public class DataModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    AuthManager provideAuthManager(SharedPreferences sharedPreferences) {
        return new AuthManager(sharedPreferences);
    }

    @Provides
    @Singleton
    ObjectMapper provideObjectMapper() {
        return new ObjectMapper()
                .registerModule(new KotlinModule())
                .registerModule(new JodaModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
