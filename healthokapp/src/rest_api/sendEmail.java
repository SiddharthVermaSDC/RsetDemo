package rest_api;

import com.sendgrid.*;

public class sendEmail {
  public static void main(String[] args) throws SendGridException {
    SendGrid sendgrid = new SendGrid("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");

    SendGrid.Email email = new SendGrid.Email();

    email.addTo("len.7206@gmail.com.com");
    email.setFrom("you@youremail.com");
    email.setSubject("Sending with SendGrid is Fun");
    email.setHtml("and easy to do anywhere, even with Java");

    SendGrid.Response response = sendgrid.send(email);
  }
}