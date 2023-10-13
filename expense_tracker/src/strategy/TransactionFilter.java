package strategy;

import java.util.*;
import model.Transaction;

interface TransactionFilter{

    public List<Transaction> filter(List<Transaction> transactions);

}