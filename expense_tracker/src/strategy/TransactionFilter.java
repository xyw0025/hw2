package strategy;

import java.util.*;
import model.Transaction;

/**
 * Interafce to be used by several filter classes
 */
public interface TransactionFilter{
    /**
     * Abstract method to filter the transactions
     * @param transactions List of transactions to be filtered
     */
    public List<Transaction> filter(List<Transaction> transactions);

}