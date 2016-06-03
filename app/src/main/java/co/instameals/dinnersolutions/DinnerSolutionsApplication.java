package co.instameals.dinnersolutions;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import co.instameals.dinnersolutions.dagger.DataModule;
import co.instameals.dinnersolutions.dagger.DinnerSolutionsComponent;
import co.instameals.dinnersolutions.dagger.DaggerDinnerSolutionsComponent;

public class DinnerSolutionsApplication extends Application {

    private DinnerSolutionsComponent dinnerSolutionsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        dinnerSolutionsComponent = DaggerDinnerSolutionsComponent.builder()
                .dataModule(new DataModule())
                .build();
        dinnerSolutionsComponent.inject(this);
    }

    public static DinnerSolutionsApplication from(Context context) {
        return (DinnerSolutionsApplication) context.getApplicationContext();
    }

    public DinnerSolutionsComponent component() {
        return dinnerSolutionsComponent;
    }
}
