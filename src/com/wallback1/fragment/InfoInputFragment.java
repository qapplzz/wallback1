package com.wallback1.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wallback1.activity.InfoInputActivity;
import com.wallback1.activity.R;

public class InfoInputFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.information_input, container, false);
		return v;
	}

	@Override
	public void onViewCreated(View v, Bundle savedInstanceState) {
		super.onViewCreated(v, savedInstanceState);
		final EditText editName = (EditText) v.findViewById(R.id.name);
		final EditText editBirth = (EditText) v.findViewById(R.id.birthday);
		final EditText editDate = (EditText) v.findViewById(R.id.date);

		Button btn = (Button) v.findViewById(R.id.done);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = editName.getText().toString();
				String birth = editBirth.getText().toString();
				String date = editDate.getText().toString();

				SharedPreferences pref = ((InfoInputActivity) getActivity())
						.getSharedPreferences("LoveLove", 0);

				SharedPreferences.Editor edit = pref.edit();
				edit.putString("name", name);
				edit.putString("birth", birth);
				edit.putString("date", date);
				edit.commit();

			}
		});
	}
}
