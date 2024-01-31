package com.example.notify.Service;



import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class emailServices {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String body,String imagePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        String htmlContent = "<html><body><p>" + body + "</p><img src='" + imagePath + "' alt='Embedded Image' /></body></html>";
        helper.setText(htmlContent, true);
        javaMailSender.send(mimeMessage);
    }








}



    

