package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableModel;

import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;

import model.Transaction;
import java.util.List;

/**
 * Class containing all the components present in the GUI
 */
public class ExpenseTrackerView extends JFrame {

  /**
   * JTable object used to display and edit cells
   */
  private JTable transactionsTable;
  /**
   * Button object to add transaction 
   */
  private JButton addTransactionBtn;
  /**
   * Button object to delete a transaction
   */
  private JButton deleteTransactionBtn;
  /**
   * Text field to enter amount present in the transaction
   */
  private JFormattedTextField amountField;
  /**
   * Text field to enter category present in the transaction
   */
  private JTextField categoryField;
  /**
   * Model that store the transaction values in the Table cells
   */
  private DefaultTableModel model;
  

  /**
   * Constructor to initialize GUI components of the application
   */
  public ExpenseTrackerView() {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger

    String[] columnNames = {"serial", "Amount", "Category", "Date"};
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");
    deleteTransactionBtn = new JButton("Delete");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);

    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    // Create table
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
    inputPanel.add(deleteTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
    buttonPanel.add(deleteTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  /**
   * Method to reinitialize the table contents using the passed transactions list
   * @param transactions list containing transaction objects used to modify the view
   */
  public void refreshTable(List<Transaction> transactions) {
      // Clear existing rows
      model.setRowCount(0);
      // Get row count
      int rowNum = model.getRowCount();
      double totalCost=0;
      // Calculate total cost
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()}); 
      }
        // Add total row
        Object[] totalRow = {"Total", null, null, totalCost};
        model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  
  

  
  /**
   * Function to access addTransaction button object
   * @return a JButton object to add transactions
   */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }
  
  /**
   * Function to access table model object
   * @return DefaultTableModel object that stores the transaction values in the cells
   */
  public DefaultTableModel getTableModel() {
    return model;
  }
  // Other view methods
  
  /**
   * Function to return the transactionsTable object 
   * @return JTable object that is used to define the structure of table
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  /**
   * Function to return the amount value in the amount TextField
   * @return returns the amount value entered by the user
   */
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  /**
   * Function to set value to the amountField
   * @param amountField default value to be assigned to the amountField
   */
  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  
  /**
   * Function to return the category value in the amount TextField
   * @return returns the category value entered by the user
   */
  public String getCategoryField() {
    return categoryField.getText();
  }

  /**
   * Function to set value to the categoryField
   * @param amountField default value to be assigned to the categoryField
   */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  /**
   * Function to access deleteTransactionBtn button object
   * @return a JButton object to delete transactions
   */
  public JButton getDeleteTransactionBtn() {
    return deleteTransactionBtn;
  }

  /**
   * Function to delete/remove an indexed row from the table
   * @param index_number Index of the transaction to be deleted in the table
   */
  public void deleteTransactionRow(int index_number) {
    this.getTableModel().removeRow(index_number);
  }
}
