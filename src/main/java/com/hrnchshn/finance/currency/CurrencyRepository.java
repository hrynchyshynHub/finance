package com.hrnchshn.finance.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("select c from Currency c order by c.created desc")
    List<Currency> findAll();
}
