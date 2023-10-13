package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerModel {

  private List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public void removeTransaction(int index) {
    transactions.remove(index);
  }

  public List<Transaction> getTransactions() {
    final List<Transaction> copyTransactions;
    Collections.copy(transactions, copyTransactions);
    return copyTransactions;
  }

}