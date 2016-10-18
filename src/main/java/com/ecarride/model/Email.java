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
        subject = "Driver Verification";
        String msg ="<table>";
        Iterator iterator = contents.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            msg = msg + pair.getValue();
        }
        msg += "</table>";
        final String from ="han@cacsnyc.com";
        final  String password ="Mh123456";

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

    public static void sendEmailByLocalhost() {
        // Recipient's email ID needs to be mentioned.
        String to = "han@cacsnyc.com";

        // Sender's email ID needs to be mentioned
        String from = "web@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
