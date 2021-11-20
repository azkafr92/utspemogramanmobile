package com.learnandroid.utspemogramanmobile;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class BookkeeperAdapter extends FragmentStatePagerAdapter {
  public BookkeeperAdapter(FragmentManager fm) {
    super(fm);
  }
  @Override
  public Fragment getItem(int pos) {
    Fragment f = null;
    if (pos == 0) {
      f = new BookkeeperIncomeFragment();
    } else if (pos == 1) {
      f = new BookkeeperOutcomeFragment();
    }
    return f;
  }
  @Override
  public int getCount() {
    return 2;
  }
  @Override
  public CharSequence getPageTitle(int pos) {
    String title = null;

    if (pos == 0) {
      title = "Pemasukan";
    } else if (pos == 1) {
      title = "Pengeluaran";
    }
    return title;
  }
}
