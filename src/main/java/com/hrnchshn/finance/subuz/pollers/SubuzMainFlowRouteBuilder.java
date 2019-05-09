package com.hrnchshn.finance.subuz.pollers;

import com.hrnchshn.finance.subuz.managers.EmailSenderProcessor;
import com.hrnchshn.finance.subuz.managers.JourneyAvailabilityProcessor;
import com.hrnchshn.finance.subuz.managers.TelegramSenderProcessor;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class SubuzMainFlowRouteBuilder extends RouteBuilder {

    @BeanInject
    private JourneyAvailabilityProcessor availabilityProcessor;
    @BeanInject
    private EmailSenderProcessor emailSenderProcessor;
    @BeanInject
    private TelegramSenderProcessor telegramSenderProcessor;

    @Override
    public void configure() throws Exception {
        from("timer:journeyAvailabilityTimer?period=2m")
                .log("checking availability")
                .process(availabilityProcessor)
                .multicast()
                .parallelProcessing()
                .to("direct:emailSender", "direct:telegramSender");

        from("direct:emailSender")
                .process(emailSenderProcessor);
        from("direct:telegramSender")
                .process(telegramSenderProcessor);
//                .to("telegram:bots/750159563:AAGnvO09GP1DiylzSQGr-7Vwxo95DNaQ_KI");
    }
}
