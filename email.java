import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class email {

    public static void main(String[] args){
        //System.out.println("Enter your email address: ");
        //Scanner sc = new Scanner(System.in);
        //String email = sc.nextLine();
        sendEmail("mayozasier@gmail.com");


    }

    public static void sendEmail(String email){
        String username = "backups202324@gmail.com";
        String password = "comenius123";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("backups202324@gmail.com", password   );

            }

        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject("Backup");

            message.setText("Your backup has been done succesfully!!");

            Transport.send(message);

            System.out.println("Email sent successfully to: "+email);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



}
