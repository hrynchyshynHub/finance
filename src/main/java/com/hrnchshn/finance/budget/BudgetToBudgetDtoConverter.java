package com.hrnchshn.finance.budget;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class BudgetToBudgetDtoConverter implements EntityToDtoConverter<Budget, BudgetDto> {

    @Override
    public Budget doForward(BudgetDto budgetDto, Budget budget) {
        budget = Optional.ofNullable(budget)
                         .orElse(new Budget());
        setIfNotNull(budget::setDescription, budgetDto.getDescription());
        setIfNotNullAndNotEmpty(budget::setName, budgetDto.getName());
        setIfNotNull(budget::setTotalAmount, budgetDto.getTotalAmount());
        setIfNotNull(budget::setGoalAmount, budgetDto.getGoalAmount());
        if(budgetDto.getCurrencyType() != null){
            setIfNotNull(budget::setCurrencyType, Budget.CurrencyType.valueOf(budgetDto.getCurrencyType()));
        }
        return budget;
    }

    @Override
    public BudgetDto doBackward(Budget budget) {
        String type = Optional.ofNullable(budget.getCurrencyType())
                .map(Budget.CurrencyType::name)
                .orElse(null);
        return BudgetDto.builder()
                .id(budget.getId())
                .name(budget.getName())
                .totalAmount(budget.getTotalAmount())
                .goalAmount(budget.getGoalAmount())
                .description(budget.getDescription())
                .currencyType(type)
                .build();
    }
}
