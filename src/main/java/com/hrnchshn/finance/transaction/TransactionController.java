package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.constants.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.TRANSACTIO_PATH)
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping
    private TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.createTransaction(transactionDto);
    }

    @PutMapping("/{id}")
    private void updateTransaction(@PathVariable("id")Long id, @RequestBody TransactionDto transactionDto) {
        transactionService.updateTransaction(id, transactionDto);
    }

    @DeleteMapping("/{id}")
    private void deleteTransaction(@PathVariable("id")Long id) {
        transactionService.deleteTransaction(id);
    }
}
