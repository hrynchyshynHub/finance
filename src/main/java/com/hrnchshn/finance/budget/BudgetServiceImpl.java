package com.hrnchshn.finance.budget;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import com.hrnchshn.finance.transaction.TransactionDto;
import com.hrnchshn.finance.transaction.TransactionToTransactionDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


/**
 * @author ivan.hrynchyshyn
 */
@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

    private final AUserRepository userRepository;
    private final BudgetRepository budgetRepository;
    private final BudgetToBudgetDtoConverter budgetConverter;
    private final TransactionToTransactionDtoConverter transactionToTransactionDtoConverter;

    @Override
    public BudgetDto saveBudget(BudgetDto budgetDto) {
       Budget budget = budgetConverter.doForward(budgetDto, null);
       budget.setUser(getAuthUser());
       return budgetConverter.doBackward(budgetRepository.save(budget));
    }

    @Override
    public void updateBudget(Long id, BudgetDto budgetDto) {
        budgetRepository.findById(id)
                .map(budget -> budgetConverter.doForward(budgetDto, budget))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    @Override
    public BudgetDto getBudgetById(Long id) {
        return budgetRepository.findById(id)
                .map(budgetConverter::doBackward)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<BudgetDto> getAll() {
        return budgetConverter.doBackward(budgetRepository.findAllByUser(getAuthUser()));
    }

    @Override
    public List<TransactionDto> getBudgetTransactions(Long budgetId) {
        Budget budget = budgetRepository.findById(budgetId)
                .orElseThrow(EntityNotFoundException::new);
        return transactionToTransactionDtoConverter.doBackward(budget.getTransactions());
    }

    private AUser getAuthUser(){
        String username = String.class.cast(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
       return userRepository.findByUsername(username);
    }
}
