class CategoryFilter extends TransactionFilter
{   
    String filterCategory;

    public CategoryFilter(String filterCategory)
    {
        this.filterCategory = filterCategory;
    }

    public List<Transaction> filter(List<Transaction> transactions)
    {
        List<Employee> transactionsWithFilterCategory = transactions.stream()
                                                    .filter(q -> q.getCategory().equals(filterCategory))
                                                    .collect(Collectors.toList());
        return transactionsWithFilterCategory;
    }
}