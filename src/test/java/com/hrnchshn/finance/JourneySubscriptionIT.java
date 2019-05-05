package com.hrnchshn.finance;

import com.hrnchshn.finance.subuz.dao.JourneySubscriptionDao;
import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * @author ivan.hrynchyshyn
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class JourneySubscriptionIT {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private JourneySubscriptionDao journeySubscriptionDao;


    @Test
    public void test(){
        JourneySubscription journeySubscription = JourneySubscription.builder()
                .destPlace(23L)
                .srcPlace(24L)
                .isActive(false)
                .build();
        journeySubscription.setCreatedBy("sd");
        journeySubscription.setCreated(new Timestamp(System.currentTimeMillis()));
        journeySubscription.setUser(null);
        journeySubscriptionDao.save(journeySubscription);

        System.out.println(journeySubscriptionDao.findAll());
    }
}
