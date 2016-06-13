package co.instameals.dinnersolutions.dagger;

import javax.inject.Singleton;

import co.instameals.dinnersolutions.DinnerSolutionsApplication;
import co.instameals.dinnersolutions.LoginActivity;
import co.instameals.dinnersolutions.MainActivity;
import dagger.Component;

@Singleton
@Component(modules = {DataModule.class, APIClientModule.class})
public interface DinnerSolutionsComponent {
    void inject(DinnerSolutionsApplication application);

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);
}
