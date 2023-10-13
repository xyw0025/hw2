package strategy;

import java.util.*;
import view.Transaction;

interface TransactionFilter{

    public List<Transaction> filter(List<Transaction> transactions);

}