package com.wallback1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "WallBack1.db";

	public DatabaseAdapter(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// this.sql = context.getResources().getString(R.raw.database);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE Friends ("
				+ "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "contact_id INTEGER," + "name INTEGER NOT NULL,"
				+ "phone_number TEXT NOT NULL," + "profile_image TEXT,"
				+ "address TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
