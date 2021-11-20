package com.learnandroid.utspemogramanmobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
  public DBHelper(Context context) {
    super(context, TransactionTable.DB_NAME, null, TransactionTable.DB_VERSION);
  }
  @Override
  public void onCreate(SQLiteDatabase db){
    try {
      db.execSQL(TransactionTable.CREATE_TB);
      db.execSQL(TransactionTable.INITIAL_DATA);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(String.format("DROP TABLE IF EXISTS %s", TransactionTable.TB_NAME));
    onCreate(db);
  }
}
