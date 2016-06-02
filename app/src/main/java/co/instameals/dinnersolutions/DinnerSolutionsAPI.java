package co.instameals.dinnersolutions;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DinnerSolutionsAPI extends Service {
    public DinnerSolutionsAPI() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
