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
        setIfNotNull(budget::setName, budgetDto.getName());
        setIfNotNull(budget::setCurrencyType, Budget.CurrencyType.valueOf(budgetDto.getCurrencyType()));
        return budget;
    }

    @Override
    public BudgetDto doBackward(Budget budget) {
        return BudgetDto.builder()
                .id(budget.getId())
                .name(budget.getName())
                .description(budget.getDescription())
                .currencyType(budget.getCurrencyType().name())
                .build();
    }
}
