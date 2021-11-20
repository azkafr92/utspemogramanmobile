package com.learnandroid.utspemogramanmobile;

public class TransactionTable {
  static final String ROW_ID = "_id_";
  static final String CATEGORY = "category";
  static final String TITLE = "title";
  static final String AMOUNT = "amount";
  static final String DATE = "_date_";
  static final String DB_NAME = "app_db";
  static final String TB_NAME = "_transaction_";
  static final String[] TB_COLUMNS =
      new String[]{ROW_ID, CATEGORY, TITLE, AMOUNT, DATE};
  static final int DB_VERSION = 1;
  static final String CREATE_TB = "CREATE TABLE '_transaction_' (" +
    "'_id_' INTEGER NOT NULL, " +
    "'category' TEXT NOT NULL, " +
    "'title' TEXT NOT NULL, " +
    "'amount' INTEGER NOT NULL, " +
    "'_date_' TEXT NOT NULL, " +
    "PRIMARY KEY('_id_' AUTOINCREMENT));";
  static final String INITIAL_DATA = "INSERT INTO '_transaction_' " +
      "('_id_', 'category', 'title', 'amount', '_date_') values " +
      "(1, 'Pengeluaran', 'Beli buku', 20000, '15/10/2021')," +
      "(2, 'Pemasukan', 'Gaji', 50000, '14/10/2021')";
}
