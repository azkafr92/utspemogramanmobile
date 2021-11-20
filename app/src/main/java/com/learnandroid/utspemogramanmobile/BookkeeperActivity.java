package com.learnandroid.utspemogramanmobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class BookkeeperActivity extends AppCompatActivity {

  ViewPager viewPager;
  BookkeeperAdapter bookkeeperAdapter;
  TabLayout tabLayout;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bookkeeper);
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    viewPager = findViewById(R.id.viewpager_bookkeeper);
    tabLayout = findViewById(R.id.tablayout_bookkeeper);
    bookkeeperAdapter = new BookkeeperAdapter(getSupportFragmentManager());
    viewPager.setAdapter(bookkeeperAdapter);
    tabLayout.setupWithViewPager(viewPager);
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
