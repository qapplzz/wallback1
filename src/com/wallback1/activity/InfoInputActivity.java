package com.wallback1.activity;

import android.support.v4.app.Fragment;

import com.wallback1.fragment.InfoInputFragment;

public class InfoInputActivity extends BaseSinglePaneActivity {

	@Override
	protected Fragment onCreatePane() {
		return new InfoInputFragment();

	}

}
