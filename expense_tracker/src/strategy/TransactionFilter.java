package strategy;

import java.util.*;
import model.Transaction;

public interface TransactionFilter{

    public List<Transaction> filter(List<Transaction> transactions);

}