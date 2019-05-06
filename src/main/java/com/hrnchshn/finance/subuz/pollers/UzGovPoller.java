package com.hrnchshn.finance.subuz.pollers;

import com.hrnchshn.finance.subuz.managers.JourneyAvailabilityManager;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class UzGovPoller extends RouteBuilder {

    @BeanInject
    private JourneyAvailabilityManager availabilityManager;

    @Override
    public void configure() throws Exception {
        from("timer:journeyAvailabilityManager?period=2m")
                .log("checking availability")
                .bean(availabilityManager, "checkJourneySubscriptionsAvailability");
    }
}
