package strategy;

import java.util.*;
import java.util.stream.Collectors;
import model.Transaction;

public class CategoryFilter implements TransactionFilter
{   
    String filterCategory;

    public CategoryFilter(String filterCategory)
    {
        this.filterCategory = filterCategory;
    }

    public List<Transaction> filter(List<Transaction> transactions)
    {
        List<Transaction> transactionsWithFilterCategory = transactions.stream()
                                                    .filter(q -> q.getCategory().equals(filterCategory))
                                                    .collect(Collectors.toList());
        return transactionsWithFilterCategory;
    }
}