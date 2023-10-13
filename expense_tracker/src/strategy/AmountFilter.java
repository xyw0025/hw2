package strategy;

import java.util.*;
import java.util.stream.Collectors;
import model.Transaction;

public class AmountFilter implements TransactionFilter
{
    String filterAmount;

    public AmountFilter(double filterAmount)
    {
        this.filterAmount = filterAmount;
    }

    public List<Transaction> filter(List<Transaction> transactions)
    {
        List<Employee> transactionsAboveFilterAmount = transactions.stream()
                                                    .filter(q -> q.getAmount() >= filterAmount)
                                                    .collect(Collectors.toList());
        return transactionsAboveFilterAmount;
    }
}