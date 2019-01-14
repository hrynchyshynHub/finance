package com.hrnchshn.finance.money;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.common.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface MoneyRepository extends CommonRepository<Money> {

    @Query("SELECT m from Money m where m.user =:user")
    List<Money> findByUser(@Param("user") AUser user);
}

