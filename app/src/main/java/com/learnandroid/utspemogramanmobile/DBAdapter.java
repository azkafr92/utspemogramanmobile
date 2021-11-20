package com.learnandroid.utspemogramanmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class DBAdapter {
  Context context;
  SQLiteDatabase sqLiteDatabase;
  DBHelper dbHelper;

  public DBAdapter(Context context) {
    this.context = context;
    dbHelper = new DBHelper(context);
  }
  public DBAdapter openDB() {
    try {
      sqLiteDatabase = dbHelper.getWritableDatabase();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return this;
  }
  public void closeDB() {
    try {
      sqLiteDatabase.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public long add(String category, String title, int amount, String date) {
    try {
      ContentValues values = new ContentValues(4);
      values.put(TransactionTable.CATEGORY, category);
      values.put(TransactionTable.TITLE, title);
      values.put(TransactionTable.AMOUNT, amount);
      values.put(TransactionTable.DATE, date);
      return sqLiteDatabase.insert(TransactionTable.TB_NAME, TransactionTable.CATEGORY, values);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }
  public Cursor getAllTransactions() {
    String orderBy = TransactionTable.DATE + " DESC";
    return sqLiteDatabase.query(
        TransactionTable.TB_NAME,
        TransactionTable.TB_COLUMNS,
        null,
        null,
        null,
        null,
        orderBy
    );
  }
  public Cursor getIncomeTransactions() {
    String whereClause = TransactionTable.CATEGORY + " = 'Pemasukan'";
    return sqLiteDatabase.query(
        TransactionTable.TB_NAME,
        TransactionTable.TB_COLUMNS,
        whereClause,
        null,
        null,
        null,
        null
    );
  }
  public Cursor getOutcomeTransactions() {
    String whereClause = TransactionTable.CATEGORY + " = 'Pengeluaran'";
    return sqLiteDatabase.query(
        TransactionTable.TB_NAME,
        TransactionTable.TB_COLUMNS,
        whereClause,
        null,
        null,
        null,
        null
    );
  }
}
