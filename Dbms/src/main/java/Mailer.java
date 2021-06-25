import java.util.Properties;  

import javax.mail.*;
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  

public class Mailer
{
	public static void send(String from,String msg)
	{
		final String user="iit2019073@iiita.ac.in";
		final String pass="DivineDestiny20";
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");  
		props.put("mail.smtp.port", 587);
		Session session = Session.getDefaultInstance(props,new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{  
				return new PasswordAuthentication(user,pass);  
			}  
		});
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(user));
			message.setSubject("User Query");
			message.setText(msg);
			Transport.send(message);
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static void verify(String to,String num)
	{
		final String user="iit2019073@iiita.ac.in";
		final String pass="DivineDestiny20";
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");  
		props.put("mail.smtp.port", 587);
		Session session = Session.getDefaultInstance(props,new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{  
				return new PasswordAuthentication(user,pass);  
			}  
		});
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject("Email Verification");
			message.setText("Your verification number is "+num);
			Transport.send(message);
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
}