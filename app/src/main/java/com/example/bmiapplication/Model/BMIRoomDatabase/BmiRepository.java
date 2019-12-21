package com.example.bmiapplication.Model.BMIRoomDatabase;


import android.app.Application;
import android.provider.ContactsContract;

import java.util.List;

public class BmiRepository {

    private BmiDAO bmiDAO;
    private List<Bmi> mAllBmis;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public BmiRepository(Application application) {
        BmiDatabase db = BmiDatabase.getDatabase(application);
        bmiDAO = db.bmiDAO();
        mAllBmis = bmiDAO.getAllBmi();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public List<Bmi> getmAllBmis() {
        return mAllBmis;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(final Bmi bmi) {
        BmiDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                bmiDAO.insert(bmi);
            }
        });

    }
}


