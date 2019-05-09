package com.hrnchshn.finance.subuz.pollers;

import com.hrnchshn.finance.subuz.managers.EmailSenderManager;
import com.hrnchshn.finance.subuz.managers.JourneyAvailabilityManager;
import com.hrnchshn.finance.subuz.managers.TelegramSenderManager;
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
    @BeanInject
    private EmailSenderManager emailSenderManager;
    @BeanInject
    private TelegramSenderManager telegramSenderManager;

    @Override
    public void configure() throws Exception {
        from("timer:journeyAvailabilityManager?period=2m")
                .log("checking availability")
                .process(availabilityManager)
                .multicast()
                .parallelProcessing()
                .to("direct:emailSender", "direct:telegramSender");

        from("direct:emailSender")
                .process(emailSenderManager);
        from("direct:telegramSender")
                .process(telegramSenderManager);
//                .to("telegram:bots/750159563:AAGnvO09GP1DiylzSQGr-7Vwxo95DNaQ_KI");
    }
}
