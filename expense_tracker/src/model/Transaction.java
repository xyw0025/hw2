package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* Transaction class that specifies the structure of the transactions
*/
public class Transaction {

  /**
   * variable to hold the numerical value within the transaction
   */
  final private double amount;
  /**
   * variable to hold the category of the transaction 
   */
  final private String category;
  /**
   * variable to store the timestamp - date and time of the transaction
   */
  final private String timestamp;

  /**
   * Constructor to initialize class variables with some default values
   * @param amount default amount to be assigned to the variable amount when creating a transaction
   * @param category default value to be assigned to the category variable
   */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /**
   * Function to get the amount value in the transaction
   * @return amount present in the transaction
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Function to get category value in the transaction
   * @return category mentioned in the transaction
   */
  public String getCategory() {
    String copyCategory = String.valueOf(category);
    return copyCategory;
  }
  
  /**
   * Function to get the timestamp of the transaction
   * @return timestamp of the transaction
   */
  public String getTimestamp() {
    String copyTimeStamp = String.valueOf(timestamp);
    return copyTimeStamp;
  }

  /**
   * Function to generate a timestamp in a particular format for the transaction
   * @return generates the timestamp for the newly created transaction
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}