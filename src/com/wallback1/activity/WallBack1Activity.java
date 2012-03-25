package com.wallback1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WallBack1Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = null;
		if (isFirst()) {
			intent = new Intent(this, InfoInputActivity.class);
		} else {
			intent = new Intent(this, LoveMainActivity.class);
		}
		startActivity(intent);
	}

	private boolean isFirst() {
		return true;
	}

}