package com.hrnchshn.finance.subuz.dao;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Repository
public interface JourneySubscriptionDao extends JpaRepository<JourneySubscription, Long> {
    List<JourneySubscription> findAllByUserOrderByCreated(AUser user);
    List<JourneySubscription> findByIsActiveTrue();
}
