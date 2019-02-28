package com.hrnchshn.finance.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
