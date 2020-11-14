package com.alfi.senangalquran;

import android.app.Application;
import android.content.res.Resources;

import com.alfi.senangalquran.database.DatabaseHelper;
import com.alfi.senangalquran.utils.PreferenceApp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class App extends Application {

    private static Resources resources;

    @Override
    public void onCreate() {
        super.onCreate();

        resources = getResources();
        DatabaseHelper.initDatabase(this);
        PreferenceApp.initPreferences(this);
    }

    public static BufferedReader getRawResources(int res){
        InputStream streamReader = resources.openRawResource(res);
        return new BufferedReader(new InputStreamReader(streamReader));
    }

}
