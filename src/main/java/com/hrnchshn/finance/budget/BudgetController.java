package com.hrnchshn.finance.budget;

import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.transaction.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequestMapping(Api.BUDGET_PATH)
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping
    public List<BudgetDto> getBudgets(){
        return budgetService.getAll();
    }

    @GetMapping("/{id}")
    public BudgetDto getBudget(@PathVariable("id") Long id){
        return budgetService.getBudgetById(id);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getBudgetTransactions(@PathVariable("id") Long id){
        return budgetService.getBudgetTransactions(id);
    }

    @PostMapping
    public BudgetDto createBudget(@RequestBody BudgetDto budgetDto){
        return budgetService.saveBudget(budgetDto);
    }

    @PutMapping("/{id}")
    public void updateBudget(@PathVariable("id") Long id,
                             @RequestBody BudgetDto budgetDto){
        budgetService.updateBudget(id, budgetDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable("id") Long id){
        budgetService.deleteBudget(id);
    }

}
