package com.learnandroid.utspemogramanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView pemasukanCard, bookkeeperCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pemasukanCard = findViewById(R.id.transaction_card);
        pemasukanCard.setOnClickListener(this);
        bookkeeperCard = findViewById(R.id.bookkeeper_card);
        bookkeeperCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent move;
        switch (v.getId()) {
            case R.id.transaction_card:
                move = new Intent(MainActivity.this, TransactionActivity.class);
                startActivity(move);
                break;
            case R.id.bookkeeper_card:
                move = new Intent(MainActivity.this, BookkeeperActivity.class);
                startActivity(move);
                break;
        }
    }
}