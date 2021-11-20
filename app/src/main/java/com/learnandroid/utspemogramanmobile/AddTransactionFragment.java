package com.learnandroid.utspemogramanmobile;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;

public class AddTransactionFragment extends Fragment {
    private Spinner dropdown;
    private EditText dateInput;
    public static final int REQUEST_CODE = 11;
    public DBAdapter db;

    public AddTransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_add_transaction, parent, false);

        final FragmentManager fm = ((AppCompatActivity)getActivity()).getSupportFragmentManager();

        db = new DBAdapter(getContext());
        dropdown = root.findViewById(R.id.item_category);
        EditText titleInput = root.findViewById(R.id.title_input);
        EditText amountInput = root.findViewById(R.id.amount_input);
        dateInput = root.findViewById(R.id.date_input);
        dateInput.setOnClickListener(v -> {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.setTargetFragment(AddTransactionFragment.this, REQUEST_CODE);
            datePickerFragment.show(fm, "datePicker");
        });
        Button addTransactionButton = root.findViewById(R.id.button_add_transaction);
        addTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    db.openDB();
                    db.add(
                        dropdown.getSelectedItem().toString(),
                        titleInput.getText().toString(),
                        Integer.parseInt(amountInput.getText().toString()),
                        dateInput.getText().toString()
                    );
                    db.closeDB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Snackbar addTransactionSnackbar = Snackbar.make(
                    root,
                    "Transaksi berhasil ditambahkan",
                    Snackbar.LENGTH_SHORT
                );
                addTransactionSnackbar.setAnchorView(R.id.button_show_add_transaction).show();
                hideAddTransactionFragment(fm);
            }
        });

        Button cancelTransactionButton = root.findViewById(R.id.button_cancel_transaction);
        cancelTransactionButton.setOnClickListener(view -> {
            Snackbar cancelTransactionSnackbar = Snackbar.make(
                    root,
                    "Transaksi dibatalkan",
                    Snackbar.LENGTH_SHORT
            );
            cancelTransactionSnackbar.setAnchorView(R.id.button_show_add_transaction).show();
            hideAddTransactionFragment(fm);
        });

        initItemCategoryOptions();

        return root;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            String selectedDate = data.getStringExtra("selectedDate");
            dateInput.setText(selectedDate);
        }
    }
    private void initItemCategoryOptions() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(getActivity(), R.array.item_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
    }
    private void hideAddTransactionFragment(FragmentManager fm) {
        RecentTransactionFragment recentTransactionFragment = new RecentTransactionFragment();
        fm.beginTransaction().replace(R.id.add_transaction_placeholder, recentTransactionFragment).commit();
    }
}
