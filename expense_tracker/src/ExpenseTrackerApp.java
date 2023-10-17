import javax.swing.JOptionPane;
// import javax.swing.table.DefaultTableModel;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
// import model.Transaction;
// import controller.InputValidation;

public class ExpenseTrackerApp {

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

  private static boolean deleteTransaction(ExpenseTrackerController controller, ExpenseTrackerView view) {
    int row_index = view.getTransactionsTable().getSelectedRow();

    if (checkRowNum(view, row_index)) {
      boolean is_deleted = controller.deleteTransaction(row_index);
      return is_deleted;
    } else {
      return false;
    }
  }

  private static boolean checkRowNum(ExpenseTrackerView view, int row_index) {
    int row_counts = view.getTransactionsTable().getRowCount();
    return (row_index < row_counts);
  }

}