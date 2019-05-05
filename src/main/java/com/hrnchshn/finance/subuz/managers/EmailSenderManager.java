package com.hrnchshn.finance.subuz.managers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author ivan.hrynchyshyn
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class EmailSenderManager {

    private final JavaMailSender sender;

    public void sendEmail(String receiver, String body, String subject){
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            //TODO: Replace hardcoded receiver mail.
            helper.setTo("vaniahrynchyshyn@gmail.com");
            helper.setText(body);
            helper.setSubject(subject);
            sender.send(message);
        } catch (MessagingException e) {
            log.error("Can`t send email to " + receiver, e);
        }

    }
}
