package com.learnandroid.utspemogramanmobile;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BookkeeperOutcomeFragment extends Fragment {
  private ArrayList<TransactionModel> transactionModelArrayList;

  public BookkeeperOutcomeFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_bookkeeper_outcome, container, false);

    try {
      transactionModelArrayList = retrieveData();
    } catch (Exception e) {
      e.printStackTrace();
    }

    RecyclerView rv = (RecyclerView) root.findViewById(R.id.outcome_transaction_view);
    RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
    rv.setLayoutManager(lm);

    TransactionAdapter transactionAdapter = new TransactionAdapter(transactionModelArrayList);
    rv.setAdapter(transactionAdapter);

    return root;
  }
  private ArrayList<TransactionModel> retrieveData() throws ParseException {
    ArrayList<TransactionModel> dataList = new ArrayList<>();
    DBAdapter db = new DBAdapter(getContext());
    db.openDB();
    Cursor c = db.getOutcomeTransactions();

    while (c.moveToNext()) {
      int id = c.getInt(0);
      String category = c.getString(1);
      String title = c.getString(2);
      int amount = c.getInt(3);
      Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(c.getString(4));
      TransactionModel model = new TransactionModel(id, category, title, amount, date);
      dataList.add(model);
    }
    c.close();
    db.closeDB();
    return dataList;
  }
}