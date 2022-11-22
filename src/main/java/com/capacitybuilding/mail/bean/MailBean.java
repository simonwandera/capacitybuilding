package com.capacitybuilding.mail.bean;

import javax.ejb.*;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Properties;

@Stateless
@Remote
@Named("mailBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MailBean implements MailBeanI{

    @Override
    public void sendMail() {
//        mail sender
        String to = "simonwandera12@gmail.com";

//        mail recipient
        String from = "wanderasimoh@gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from, "password");
            }
        });

//        used to deburg smtp issues
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Skytrix in automation");
            message.setText("This is just for presentation purposes");
            System.out.println("Sending...");
            Transport.send(message);
            System.out.println("Message sent successfully...");

        }catch (MessagingException mex){


        }
    }
}
