package com.example.projectTestLibrary;

import com.example.projectTestLibrary.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailComponent {

    private static final String MAILTO = "adamjerzyjanowski@gmail.com";

    @Autowired
    private MailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public boolean sendSimpleMail(Contact contact) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(contact.getEmail());
        mailMessage.setTo(MAILTO);
        mailMessage.setText(contact.getMessage());

        try {
            mailSender.send(mailMessage);
            return true;
        } catch (MailException e) {
            return false;
        }
    }

    public boolean sendHtmlMail(Contact contact) {

        Context context = new Context();
        context.setVariable("contact", contact);
        final String CONTENT = templateEngine.process("/author/mailView/mailView.html",context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage);

        try {
            mailMessage.setFrom(contact.getEmail());
            mailMessage.setTo(MAILTO);
            mailMessage.setSubject("Wiadomosc z Twojej strony");
            mailMessage.setText(CONTENT,true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
