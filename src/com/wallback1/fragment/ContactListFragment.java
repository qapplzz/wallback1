package com.wallback1.fragment;

import java.io.InputStream;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.wallback1.activity.R;
import com.wallback1.activity.application.GlobalApplication;

public class ContactListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.contact_list, container, false);

		// check saved friends list
		boolean hasList = false;
		if (hasList) {

		} else {
			view.findViewById(android.R.id.list).setVisibility(View.GONE);
			View addView = view.findViewById(R.id.addContact);
			addView.setVisibility(View.VISIBLE);
			addView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					startContactListActivity();
				}
			});
		}
		return view;
	}

	private void startContactListActivity() {
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
		startActivityForResult(intent, 1);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Uri dataUri = data.getData();
		Context context = GlobalApplication.getGlobalApplicationContext();
		Cursor cursor = context.getContentResolver().query(dataUri, null, null,
				null, null);
		String people_Number = null;
		while (cursor.moveToNext()) {
			int getcolumnId = cursor
					.getColumnIndex(ContactsContract.Contacts._ID);
			long id = cursor.getLong(getcolumnId);
			String people_Name = cursor
					.getString(cursor
							.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
			String hasPhoneNumber = cursor
					.getString(cursor
							.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
			if (hasPhoneNumber.equalsIgnoreCase("1")) {
				hasPhoneNumber = "true";
			} else {
				hasPhoneNumber = "false";
			}
			if (Boolean.parseBoolean(hasPhoneNumber)) {
				Cursor phones = context.getContentResolver().query(
						ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null,
						ContactsContract.CommonDataKinds.Phone.CONTACT_ID
								+ " = " + id, null, null);
				while (phones.moveToNext()) {
					people_Number = phones
							.getString(phones
									.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				}
				phones.close(); // End
			}
			// idView.setText(String.valueOf(id));
			// phone.setText(people_Name);
			// name.setText(people_Number);
			Uri uri = ContentUris.withAppendedId(
					ContactsContract.Contacts.CONTENT_URI, id);

			Log.d("TAG", "id = " + id + ", uri = " + uri);

			InputStream input = ContactsContract.Contacts
					.openContactPhotoInputStream(context.getContentResolver(),
							uri);

			// photo.setImageBitmap(BitmapFactory.decodeStream(input));
		}
	}
}
