package com.hrnchshn.finance.transaction;

import com.hrnchshn.finance.auser.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.budget.user =:user")
    List<Transaction> findAll(@Param("user") AUser user);
}
