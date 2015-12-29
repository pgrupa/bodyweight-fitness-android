package io.mazur.fit;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import net.danlew.android.joda.JodaTimeAndroid;

import io.mazur.glacier.Glacier;
import io.fabric.sdk.android.Fabric;

/**
 * TODO: Update all gif videos to match 16:9 format.
 * TODO: Update videos for Antranik new video.
 *
 * TODO BUG: ProgressActivity missing items sometimes.
 *
 * TODO: Remove delete on upgrade line of code from Realm.
 *
 * TODO: Move to Dagger 2 injection rather than using getInstance singletons.
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        Glacier.init(getApplicationContext());
        JodaTimeAndroid.init(getApplicationContext());

        if (!BuildConfig.DEBUG) {
            Fabric.with(
                    getApplicationContext(),
                    new Crashlytics()
            );
        }

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
