package com.hrnchshn.finance.budget;

import com.hrnchshn.finance.auser.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findAllByUser(AUser user);
}
