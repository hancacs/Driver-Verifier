package com.ecarride.model;

import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * Created by hanmei on 10/14/16.
 */
public class Email {



    public static void sendEmail(Map<String, String> contents, String subject, String[] recipients) throws MessagingException {
        String msg ="";
        Iterator iterator = contents.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            msg = msg + pair.getValue();
        }

        final String from = Credentials.EMAIL_FROM;
        final  String password = Credentials.PASSWORD;


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        //session.setDebug(true);
        Transport transport = session.getTransport();
        InternetAddress addressFrom = new InternetAddress(from);

        MimeMessage message = new MimeMessage(session);
        message.setSender(addressFrom);
        message.setSubject(subject);
        message.setContent(msg, "text/html");
        InternetAddress[] mailAddress_TO = new InternetAddress[recipients.length];
        for(int i = 0; i < mailAddress_TO.length; i++) {
            mailAddress_TO[i] = new InternetAddress(recipients[i]);
        }
        message.addRecipients(Message.RecipientType.TO, mailAddress_TO);

        transport.connect();
        Transport.send(message);
        transport.close();
    }
}
