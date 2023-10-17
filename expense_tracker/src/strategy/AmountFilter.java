package strategy;

import java.util.*;
import java.util.stream.Collectors;
import model.Transaction;

/**
 * Class that filters the transactions based on amount value
 */
public class AmountFilter implements TransactionFilter
{   
    /**
     * variable to store the filter amount
     */
    double filterAmount;

    /**
     * Constructor to initialize the filterAmount to a specified default value
     * @param filterAmount amount value specified by the user that will be used to filter transactions list 
     */
    public AmountFilter(double filterAmount)
    {
        this.filterAmount = filterAmount;
    }

    /**
     * Function to filter the list of transactions based on the amount value
     * @param transactions List of transactions to be fitlered
     * @return A list of filtered transactions that satisfy the filter requirement 
     */
    public List<Transaction> filter(List<Transaction> transactions)
    {
        List<Transaction> transactionsAboveFilterAmount = transactions.stream()
                                                    .filter(q -> q.getAmount() >= filterAmount)
                                                    .collect(Collectors.toList());
        return transactionsAboveFilterAmount;
    }
}