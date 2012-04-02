package com.wallback1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WallBack1Activity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = null;
		intent = new Intent(this, ContactListActivity.class);
		startActivity(intent);
	}
}