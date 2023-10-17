package strategy;

import java.util.*;
import java.util.stream.Collectors;
import model.Transaction;

/**
 * Class that filters the transactions based on category value
 */
public class CategoryFilter implements TransactionFilter
{   
    /**
     * variable to store the filter category
     */
    String filterCategory;

    /**
     * Constructor to initialize the filterCategory to a specified default value
     * @param filterCategory category value specified by the user that will be used to filter transactions list 
     */
    public CategoryFilter(String filterCategory)
    {
        this.filterCategory = filterCategory;
    }

    /**
     * Function to filter the list of transactions based on the category value
     * @param transactions List of transactions to be fitlered
     * @return A list of filtered transactions that satisfy the filter requirement 
     */
    public List<Transaction> filter(List<Transaction> transactions)
    {
        List<Transaction> transactionsWithFilterCategory = transactions.stream()
                                                    .filter(q -> q.getCategory().equals(filterCategory))
                                                    .collect(Collectors.toList());
        return transactionsWithFilterCategory;
    }
}