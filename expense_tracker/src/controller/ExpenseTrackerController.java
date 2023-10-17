package controller;

import view.ExpenseTrackerView;
import strategy.AmountFilter;
import strategy.CategoryFilter;
import java.util.List;



import model.ExpenseTrackerModel;
import model.Transaction;

/**
 * Controller part of the MVC architecture. It consists of components that will be used by the user to interact with the GUI
 * COntroller modifies the view and updates the model
 */
public class ExpenseTrackerController {
  
  /**
   * model object - used by controller to make changes in the model 
   */
  private ExpenseTrackerModel model;
  /**
   * view object - will be utilized to update the view
   */
  private ExpenseTrackerView view;
  /**
   * Instance of AmountFilter class - used to filter transactions based on amount
   */
  private AmountFilter amount_filter;
  /**
   * Instance of CategotyFilter class - used to filter transactions based on category
   */
  private CategoryFilter category_filter;

  /**
   * Class constructor to initialize class variables - model and view
   * @param model model to be modified
   * @param view view to be updated
   */
  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  /**
   * This function receives updated transactions from model and calls refreshTable to update view
   */
  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  /**
   * This function validates the inputs, and calls functions to add the transaction to the list and update the view
   * @param amount amount entered by the user in the amount field in the view
   * @param category category entered by the user
   * @return boolean indicating whether the transaction was added successfully in the model and the view was updated 
   */
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

  /**
   * Function to delete the selected transaction and update the table view
   * @param index_number specifies the index number of transaction to be deleted 
   * @return a boolean indicating whether the model and view were successful in removing the transaction at given index 
   */
  public boolean deleteTransaction(int index_number) {
    model.removeTransaction(index_number);
    view.deleteTransactionRow(index_number); // the row number also start from 0
    refresh();
    return true;
  }

  /**
   * Function to validate the filter inputs, and call functions to filter the transactions and change background color in view
   * @param filterAmount
   * @param filterCategory
   * @return boolean value indicating whether the filter operation was successful or not 
   */
  public boolean applyFilter(double filterAmount, String filterCategory)
  { 
    if (filterCategory.equals(""))
    {
      if (!InputValidation.isValidAmount(filterAmount)) {
        return false;
      }
      amount_filter = new AmountFilter(filterAmount);
      List<Transaction> filteredTransactions = amount_filter.filter(model.getTransactions());
      view.setBackgroundColor(filteredTransactions);
    }
    
    else if (filterAmount==0)
    {
      if (!InputValidation.isValidCategory(filterCategory)) {
        return false;
    }
      category_filter = new CategoryFilter(filterCategory);
      List<Transaction> filteredTransactions = category_filter.filter(model.getTransactions());
      view.setBackgroundColor(filteredTransactions);
    }

    else
    {
      return false;
    } 

  return true;
  }
}