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
   * @param t A new transaction object to be added in the list
   */
  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  /**
   * @param t Transaction object to be deleted from the list
   */
  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  /**
   * @param index Index of the transaction to be removed from the list
   */
  public void removeTransaction(int index) {
    transactions.remove(index);
  }

  /**
   * @return 
   */
  public List<Transaction> getTransactions() {
    List<Transaction> copyTransactions = new ArrayList<>(); 
    copyTransactions.addAll(transactions);
    return copyTransactions;
  }

}