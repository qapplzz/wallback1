package com.wallback1.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wallback1.activity.ContactListActivity;
import com.wallback1.activity.R;

public class ContactListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.contact_list, container, false);
		
		// check saved friends list
		boolean hasList = false;
		if(hasList) {
			
		}
		else {
			view.findViewById(android.R.id.list).setVisibility(View.GONE);
			view.findViewById(R.id.addContact).setVisibility(View.VISIBLE);
		}
		return view;
	}

}
