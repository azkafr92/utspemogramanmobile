package com.learnandroid.utspemogramanmobile;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;

public class TransactionActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_transaction);

    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    FloatingActionButton showAddIncomeButton = findViewById(R.id.button_show_add_transaction);
    showAddIncomeButton.setOnClickListener(view -> showAddTransactionFragment());

    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.add_transaction_placeholder, new RecentTransactionFragment())
        .commit();
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

  private void showAddTransactionFragment() {
    AddTransactionFragment addTransactionFragment = new AddTransactionFragment();
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.add_transaction_placeholder, addTransactionFragment)
        .commit();
  }
}