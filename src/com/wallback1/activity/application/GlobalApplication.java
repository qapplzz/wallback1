package com.wallback1.activity.application;

import android.app.Application;

public class GlobalApplication extends Application {
	private static GlobalApplication instance = null;

	public final static GlobalApplication getGlobalApplicationContext() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		initGlobalApplication();
	}

	private void initGlobalApplication() {
		instance = this;
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		instance = null;
	}

}
