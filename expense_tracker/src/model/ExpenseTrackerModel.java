package model;

import java.util.ArrayList;
import java.util.List;
// import java.util.*;

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
    List<Transaction> copyTransactions = new ArrayList<>(); 
    copyTransactions.addAll(transactions);
    return copyTransactions;
  }

}