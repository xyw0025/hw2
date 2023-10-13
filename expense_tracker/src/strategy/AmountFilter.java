package strategy;

class AmountFilter implements TransactionFilter
{
    String filterAmount;

    public AmountFilter(String filterAmount)
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