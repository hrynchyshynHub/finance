package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserRepository;
import com.hrnchshn.finance.constants.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.TRANSACTIO_PATH)
public class TransactionController {

    private final TransactionService transactionService;
    private final AUserRepository userService;

    @PostMapping
    private TransactionDto createTransaction(@RequestBody TransactionDto transactionDto, Principal principal) {
        AUser user = userService.findByUsername(principal.getName());
        return transactionService.createTransaction(transactionDto, user);
    }
}
