// Sources: Oracle Mail jar file, JavaMail API

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;

import com.sun.mail.smtp.SMTPTransport;

public class Email {
	
	String sender;
	String password;
	String recipient;
	String title;
	String message;
	
	public Email(String recipient, String title, String message) {
		this.sender = "sobrietypuzzle@gmail.com";
		this.password = "Ll6677327";
		this.recipient = recipient;
		this.title = title;
		this.message = message;
	}

    public void send() throws AddressException, MessagingException {
    		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);

        final MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(sender));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.recipient, false));

        msg.setSubject(this.title);
        msg.setText(this.message, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

        t.connect("smtp.gmail.com", this.sender, this.password);
        t.sendMessage(msg, msg.getAllRecipients());      
        t.close();
    }
}
