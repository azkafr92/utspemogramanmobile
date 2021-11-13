package com.learnandroid.utspemogramanmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView pemasukanCard, pengeluaranCard, laporanCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pemasukanCard = findViewById(R.id.pemasukanCard);
        pemasukanCard.setOnClickListener(this);
        pengeluaranCard = findViewById(R.id.pengeluaranCard);
        pengeluaranCard.setOnClickListener(this);
        laporanCard = findViewById(R.id.laporanCard);
        laporanCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pemasukanCard:
                Intent move = new Intent(MainActivity.this, PemasukanActivity.class);
                startActivity(move);
                break;
        }
    }
}