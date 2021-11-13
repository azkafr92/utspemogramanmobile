package com.learnandroid.utspemogramanmobile;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;

public class PemasukanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemasukan);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        FloatingActionButton addIncomeButton = findViewById(R.id.addIncomeButton);
        addIncomeButton.setOnClickListener(view -> {
            Snackbar snackbar= Snackbar.make(
                    findViewById(R.id.pemasukanRoot),
                    // TODO: create function addIncome
                    // TODO: create new fragment to run addIncome function
                    "Hallo",
                    Snackbar.LENGTH_SHORT
            );
            snackbar.setAnchorView(R.id.addIncomeButton);
            snackbar.show();
        });
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
}