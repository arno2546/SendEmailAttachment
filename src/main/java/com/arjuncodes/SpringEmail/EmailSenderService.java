package com.arjuncodes.SpringEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String toEmail,
                         String body,
                         String subject) throws MessagingException {

        SimpleMailMessage message= new SimpleMailMessage();
//        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true);
        message.setFrom("bpmsnoreply@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

//        FileSystemResource fileSystemResource=
//                new FileSystemResource(new File(attachment));
//        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(message);
        System.out.println("Mail sent successfully..");


    }
}
