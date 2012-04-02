package com.wallback1.activity;

import android.support.v4.app.Fragment;

import com.wallback1.fragment.ContactListFragment;

public class ContactListActivity extends BaseSinglePaneActivity {

	@Override
	protected Fragment onCreatePane() {
		return new ContactListFragment();

	}

}
