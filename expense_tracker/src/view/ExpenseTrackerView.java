package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableModel;

import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;

import model.Transaction;
import java.util.List;

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JButton deleteTransactionBtn;
  private JButton filterTransactionBtn;
  private JFormattedTextField amountField;
  private JTextField categoryField;
  private JFormattedTextField filterAmountField;
  private JTextField filterCategoryField;
  private DefaultTableModel model;
  

  public ExpenseTrackerView() {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger

    String[] columnNames = {"serial", "Amount", "Category", "Date"};
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");
    deleteTransactionBtn = new JButton("Delete");
    filterTransactionBtn = new JButton("Filter");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);

    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    JLabel filterAmountLabel = new JLabel("Filter Amount:");
    NumberFormat filterFormat = NumberFormat.getNumberInstance();

    filterAmountField = new JFormattedTextField(filterFormat);
    filterAmountField.setColumns(10);

    
    JLabel filterCategoryLabel = new JLabel("Filter Category:");
    filterCategoryField = new JTextField(10);

    // Create table
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(filterAmountLabel);
    inputPanel.add(filterAmountField);
    inputPanel.add(filterCategoryLabel); 
    inputPanel.add(filterCategoryField);
    inputPanel.add(addTransactionBtn);
    inputPanel.add(deleteTransactionBtn);
    inputPanel.add(filterTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
    buttonPanel.add(deleteTransactionBtn);
    buttonPanel.add(filterTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(1000, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

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
  

  
  
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }
  public DefaultTableModel getTableModel() {
    return model;
  }
  // Other view methods
    public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  
  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public double getFilterAmountField() {
    if(filterAmountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(filterAmountField.getText());
    return amount;
    }
  }

  public void setFilterAmountField(JFormattedTextField filterAmountField) {
    this.filterAmountField = filterAmountField;
  }

  
  public String getFilterCategoryField() {
    return filterCategoryField.getText();
  }

  public void setFilterCategoryField(JTextField filterCategoryField) {
    this.filterCategoryField = filterCategoryField;
  }

  public JButton getDeleteTransactionBtn() {
    return deleteTransactionBtn;
  }

  public JButton getFilterTransactionBtn() {
    return filterTransactionBtn;
  }

  public void setBackgroundColor(List<Transaction> filtered_t)
  {
    for(int i=0;i<getTransactionsTable().getRowCount();i++)
    {
      for(int j=0; j<filtered_t.size();j++)
      { boolean match = true;

        if (filtered_t.get(j).equals(new Transaction((double) transactionsTable.getValueAt(i,0), (String) transactionsTable.getValueAt(i,1))))
        {
          transactionsTable.addRowSelectionInterval(i, i);
        }
      }
    }
  }

  public void deleteTransactionRow(int index_number) {
    this.getTableModel().removeRow(index_number);
  }
}
