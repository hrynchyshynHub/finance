package com.hrnchshn.finance.budget;


import com.hrnchshn.finance.transaction.TransactionDto;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
public interface BudgetService {
    BudgetDto saveBudget(BudgetDto budgetDto);
    void updateBudget(Long id, BudgetDto budgetDto);
    void deleteBudget(Long id);
    BudgetDto getBudgetById(Long id);
    List<BudgetDto> getAll();
    List<TransactionDto> getBudgetTransactions(Long budgetId);
}
