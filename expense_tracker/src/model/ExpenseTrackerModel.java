package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class performs maintains and updates the transactions list 
 */
public class ExpenseTrackerModel {

  /**
   * A list of Transaction objects 
   */
  private List<Transaction> transactions;

  /**
   * Constructor initializing an empty transactions list
   */
  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  /**
   * Adds a new transaction to the list
   * @param t A new transaction object to be added in the list
   */
  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  /**
   * Removes a transaction from the list
   * @param t Transaction object to be deleted from the list
   */
  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  /**
   * Removes a transaction at given index from the list
   * @param index Index of the transaction to be removed from the list
   */
  public void removeTransaction(int index) {
    transactions.remove(index);
  }

  /**
   * Function to return the current list of transactions
   * @return List of transactions (a copy)
   */
  public List<Transaction> getTransactions() {
    List<Transaction> copyTransactions = new ArrayList<>(); 
    copyTransactions.addAll(transactions);
    return copyTransactions;
  }

}