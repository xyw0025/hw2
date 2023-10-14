package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Transaction {

  final private double amount;
  final private String category;
  final private String timestamp;

  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() {
    return amount;
  }

  public String getCategory() {
    String copyCategory = String.valueOf(category);
    return copyCategory;
  }
  
  public String getTimestamp() {
    String copyTimeStamp = String.valueOf(timestamp);
    return copyTimeStamp;
  }

  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}