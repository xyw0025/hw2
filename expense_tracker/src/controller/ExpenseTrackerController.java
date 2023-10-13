package controller;

import view.ExpenseTrackerView;
import strategy.AmountFilter;
import strategy.CategoryFilter;
import java.util.List;



import model.ExpenseTrackerModel;
import model.Transaction;
public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }

  // Other controller methods
  public boolean deleteTransaction(int index_number) {
    model.removeTransaction(index_number);
    view.deleteTransactionRow(index_number); // the row number also start from 0
    refresh();
    return true;
  }

  public boolean applyFilter(double filterAmount, String filterCategory)
  {
    if (filterCategory==null)
    {
      if (!InputValidation.isValidAmount(filterAmount)) {
      return false;
      }
      List<Transaction> filteredTransactions = new AmountFilter(filterAmount).filter(model.getTransactions());
      view.setBackgroundColor(filteredTransactions);
    }
    
    else if (filterAmount==0)
    {
      if (!InputValidation.isValidCategory(filterCategory)) {
      return false;
    }
      List<Transaction> filteredTransactions = new CategoryFilter(filterCategory).filter(model.getTransactions());
      view.setBackgroundColor(filteredTransactions);
    }
    else
    {
      return false;
    } 
  return true;
  }
}