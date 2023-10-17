import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;


/**
 * Class to start the GUI application 
 */
public class ExpenseTrackerApp {

  /**
   * Main method to instantiate the components of the Application and Listener methods
   * @param args - Default values provided during the start of execution
   */
  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

    view.getDeleteTransactionBtn().addActionListener(e -> {
      boolean is_deleted = deleteTransaction(controller, view);

      if (!is_deleted) {
        JOptionPane.showMessageDialog(view, "There's no such transaction in the table!");
        view.toFront();
      }
    });

    view.getFilterTransactionBtn().addActionListener(e -> {
      double filterAmount = view.getFilterAmountField();
      String filterCategory = view.getFilterCategoryField();

      boolean filtered = controller.applyFilter(filterAmount, filterCategory);

      if (!filtered) {
        JOptionPane.showMessageDialog(view, "Filters are not valid!");
        view.toFront();
      }
    });
  }

  /**
   * Function called by the action listener of the delete button to remove a selected transaction from the model and the view
   * @param controller controller to delete the transaction from model and view
   * @param view used to get the index of selected transaction
   * @return boolean status code indicating whether the deletion was successful or not 
   */
  private static boolean deleteTransaction(ExpenseTrackerController controller, ExpenseTrackerView view) {
    int row_index = view.getTransactionsTable().getSelectedRow();

    if (checkRowNum(view, row_index)) {
      boolean is_deleted = controller.deleteTransaction(row_index);
      return is_deleted;
    } else {
      return false;
    }
  }

  /**
   * Function to check whether the row number is valid (a precautionary function)
   * @param view To access the total number of rows present in the table
   * @param row_index Row index of the selected transaction
   * @return boolean value specifying whether the row index is valid or not
   */
  private static boolean checkRowNum(ExpenseTrackerView view, int row_index) {
    int row_counts = view.getTransactionsTable().getRowCount();
    return (row_index < row_counts);
  }

}