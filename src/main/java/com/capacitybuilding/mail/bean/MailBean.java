package com.capacitybuilding.mail.bean;

import com.capacitybuilding.mail.model.MailWrapper;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.PrivilegedAction;
import java.util.Properties;

@Stateless
@Remote
@Named("mailBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MailBean implements MailBeanI {

    private Properties properties;
    private Session session;
    private final String from;

    public MailBean() {
        this.from = "wanderasimoh@gmail.com";

        this.properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        this.session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "uulxldyyzjwbwjzq");
            }
        });

//        used to debug smtp issues
        session.setDebug(true);
    }

    public void sendMail(MailWrapper mail) throws Exception {

        if (StringUtils.isBlank(mail.getMessage()))
            throw new Exception("Mail message is required");
        if(StringUtils.isBlank(mail.getTo()))
            throw new Exception("Mail recipient is required");
        if(StringUtils.isBlank(mail.getSubject()))
            throw new Exception("Mail subject is required");

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
            message.setSubject(mail.getSubject());
            message.setText(mail.getMessage());
            System.out.println("Sending...");
            Transport.send(message);
            System.out.println("Message sent successfully...");

        } catch (MessagingException mex) {


        }
    }
}
