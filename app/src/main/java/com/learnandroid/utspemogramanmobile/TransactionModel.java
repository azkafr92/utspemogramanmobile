package com.learnandroid.utspemogramanmobile;


import java.util.Date;

public class TransactionModel {
  private int id;
  private String category;
  private String title;
  private int amount;
  private Date date;

  public TransactionModel(int id, String category, String title, int amount, Date date) {
    this.id = id;
    this.category = category;
    this.title = title;
    this.amount = amount;
    this.date = date;
  }

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
