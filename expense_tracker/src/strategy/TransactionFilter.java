package strategy;

interface TransactionFilter{

    public List<Transaction> filter(List<Transaction> transactions);

}