package com.Portfolio.Mail;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class MailService {

    @Value("${spring.mail.password}")
    private String sendGridApiKey;

    @Value("${spring.mail.sender.email}")
    private String senderEmail;

    public String sendEmail(String toEmail, String subject, String messageContent) {
        Email from = new Email(senderEmail);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", messageContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            return "Email sent successfully: " + response.getStatusCode();
        } catch (IOException ex) {
            return "Error sending email: " + ex.getMessage();
        }
    }
}
