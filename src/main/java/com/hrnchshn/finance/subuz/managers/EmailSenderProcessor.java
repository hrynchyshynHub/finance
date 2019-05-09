package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.subuz.entity.Train;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ivan.hrynchyshyn
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailSenderProcessor implements Processor {

    private final JavaMailSender sender;
    private final Configuration freemarkerConfig;

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        Map<AUser, List<Train>> map = message.getBody(Map.class);
        for (AUser receiver : map.keySet()) {
            List<Train> available = map.get(receiver);
            if (available != null && !available.isEmpty()) {
                sendEmail(receiver.getEmail(), available, "Available train found");
            }
        }
    }

    public void sendEmail(String receiver, List<Train> availableTrains, String subject){
        try {
            log.info("Sending email message...");
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
            Template t = freemarkerConfig.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, toMap(availableTrains));

            //TODO: Replace hardcoded receiver mail.
            helper.setTo("vaniahrynchyshyn@gmail.com");
            helper.setText(html, true);
            helper.setSubject(subject);
            sender.send(message);
        } catch (Exception e) {
            log.error("Can`t send email to " + receiver, e);
        }

    }

    private Map<String, Train> toMap(List<Train> trains){
        HashMap map =  new HashMap<>();
        map.put("trains", trains.stream()
                .map(this::toTrainDetails)
                .collect(Collectors.toList()));
        return map;
    }

    private Map<String, String> toTrainDetails(Train train){
        HashMap map =  new HashMap<>();
        map.put("number",  train.getTrainNumber());
        map.put("arrival",  train.getArrivalDateTime());
        map.put("departing",  train.getDepartingDateTime());
        map.put("from",  train.getFromStation());
        map.put("to",  train.getToStation());
        map.put("places",  train.getPlaces());
        return map;
    }
}
